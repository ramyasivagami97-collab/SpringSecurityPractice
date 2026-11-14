package com.example.SpringSecurityPractice.Service;

import com.example.SpringSecurityPractice.Entity.AppUser;
import com.example.SpringSecurityPractice.Repository.AppUserRepository;
import com.example.SpringSecurityPractice.Security.CustomerUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public CustomUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));


        return new CustomerUserDetail(appUser);


    }
}
