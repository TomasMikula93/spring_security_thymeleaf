package com.example.spring_security_thymeleaf.Model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

        private String firstName;
        private String lastName;
        private String email;
        private String password;

}

