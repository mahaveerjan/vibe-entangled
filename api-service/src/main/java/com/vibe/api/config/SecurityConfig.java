package com.vibe.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean // this is always BEAN
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers("/","/error").permitAll()//if its "/" or "/error" then allow without the auth
                        .anyRequest().authenticated()// all other url ask the credentials
                )
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}
