package com.aya.controller;


import com.aya.bootstrap.DataGenerator;
import com.aya.model.Employee;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee", new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());
        return "/employee/employee-create";

    }



    @PostMapping("/list")
    public String employeeList(@Valid @ModelAttribute("employee") Employee employee, BindingResult buBindingResult, Model model){

        if(buBindingResult.hasErrors()){

            model.addAttribute("states", DataGenerator.getAllStates());
            return "/employee/employee-create";
        }

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees", DataGenerator.readlAllEmployees());

        return "/employee/employee-list";

    }
}
