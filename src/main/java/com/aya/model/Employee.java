package com.aya.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

//    @NotNull  // "" -- > Except NULL, anything can be accepted
//    @NotEmpty  //" "
//    @NotBlank  //" ", "", null

    @NotBlank
    @Size(max = 12, min = 2)
    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
