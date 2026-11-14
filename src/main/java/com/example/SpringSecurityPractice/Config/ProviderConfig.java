package com.example.SpringSecurityPractice.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProviderConfig {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public ProviderConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
      DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);

      provider.setPasswordEncoder(passwordEncoder);
      return provider;

    }
}
