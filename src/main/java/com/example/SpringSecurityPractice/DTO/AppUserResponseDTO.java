package com.example.SpringSecurityPractice.DTO;

import com.example.SpringSecurityPractice.AppUserRole;

public record AppUserResponseDTO(
        Long id,
        String email,
        String name,
        AppUserRole appUserRole
) {
}
