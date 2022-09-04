package com.example.spring_security_thymeleaf.Service;

import com.example.spring_security_thymeleaf.Model.DTOs.UserRegistrationDto;
import com.example.spring_security_thymeleaf.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    String getLoggedInUserString();
}
