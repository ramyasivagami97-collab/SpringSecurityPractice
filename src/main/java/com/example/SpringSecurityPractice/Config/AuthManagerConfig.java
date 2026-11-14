package com.example.SpringSecurityPractice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
public class AuthManagerConfig {

    @Bean
   public AuthenticationManager authenticationManager(DaoAuthenticationProvider authenticationProvider){
        return  new ProviderManager(authenticationProvider);
    }
}
