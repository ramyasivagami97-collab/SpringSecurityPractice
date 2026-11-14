package com.example.SpringSecurityPractice.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record LoginRequestDTO(
       @NotBlank(message = "Email cannot be empty!")
        @Email(message = "Enter valid email address!")
        String email,

        @NotBlank(message = "Password cannot be empty!")
        String password
) {
}
