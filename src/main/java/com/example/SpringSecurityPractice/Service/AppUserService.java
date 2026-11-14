package com.example.SpringSecurityPractice.Service;

import com.example.SpringSecurityPractice.AppUserRole;
import com.example.SpringSecurityPractice.DTO.AppUserResponseDTO;
import com.example.SpringSecurityPractice.DTO.AppUsersRequestDTO;
import com.example.SpringSecurityPractice.Entity.AppUser;
import com.example.SpringSecurityPractice.Repository.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public AppUserResponseDTO addAppUser(AppUsersRequestDTO requestDTO) {

        if(appUserRepository.existsByEmail(requestDTO.email())){
            throw new RuntimeException("Email ID already exist!");
        }

        AppUser appUser = new AppUser();
        appUser.setName(requestDTO.name());
        appUser.setEmail(requestDTO.email());
        appUser.setPassword(passwordEncoder.encode(requestDTO.password()));
        appUser.setAppUserRole(AppUserRole.USER);

        AppUser savedUser = appUserRepository.save(appUser);

        return new AppUserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getAppUserRole()
        );

    }


    public List<AppUserResponseDTO> getAllUser() {
        List<AppUser> appUserList = appUserRepository.findAll();
        List<AppUserResponseDTO> responseList =  new ArrayList<>();

        for(AppUser appUser: appUserList){
            AppUserResponseDTO response = new AppUserResponseDTO(
                    appUser.getId(),
                    appUser.getName(),
                    appUser.getEmail(),
                    appUser.getAppUserRole()
            );

            responseList.add(response);
        }
        return responseList;

    }

    public AppUserResponseDTO userRoleChange(Long id, AppUserRole appUserRole) {
        if(appUserRole == null){
            throw new IllegalArgumentException("Role cannot be null!");
        }
        AppUser getRole = appUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No user can be found!"));

        getRole.setAppUserRole(appUserRole);
        AppUser updatedRole = appUserRepository.save(getRole);
        return new AppUserResponseDTO(
                updatedRole.getId(),
                updatedRole.getName(),
                updatedRole.getEmail(),
                updatedRole.getAppUserRole()
        );
    }
}
