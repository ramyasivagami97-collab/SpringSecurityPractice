package com.example.SpringSecurityPractice.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AppUsersRequestDTO(
        @NotBlank(message = "Name cannot be null!")
        String name,
        @Email(message = "Please provide valid mailing address!")
        @NotBlank(message = "Email is required!")
        String email,
        @NotBlank(message = "Password is required!")
        @Size(min = 8, max = 15)
        String password
) {
}
