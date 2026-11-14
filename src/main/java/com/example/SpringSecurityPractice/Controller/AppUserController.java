package com.example.SpringSecurityPractice.Controller;

import com.example.SpringSecurityPractice.AppUserRole;
import com.example.SpringSecurityPractice.DTO.AppUserResponseDTO;
import com.example.SpringSecurityPractice.DTO.AppUsersRequestDTO;
import com.example.SpringSecurityPractice.Service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/V1/app")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/add/user")
    public ResponseEntity<AppUserResponseDTO> addAppUser(@Valid @RequestBody AppUsersRequestDTO requestDTO){
        AppUserResponseDTO createdUser = appUserService.addAppUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/view/user")
    public List<AppUserResponseDTO> getAllUser(){
        return appUserService.getAllUser();
    }

    @PatchMapping("/admin/users/{id}/role")
    public ResponseEntity<AppUserResponseDTO> userRoleChange(@PathVariable Long id,@RequestBody AppUserRole appUserRole){
        AppUserResponseDTO roleChanged = appUserService.userRoleChange(id, appUserRole);
        return ResponseEntity.ok(roleChanged);
    }
}
