package com.example.springboothibernateapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    //authentication
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails teacher= User.withUsername("teacher").password(encoder.encode("12345")).roles("TEACHER").build();
        UserDetails student= User.withUsername("student").password(encoder.encode("12345")).roles("STUDENT").build();
        UserDetails admin= User.withUsername("admin").password(encoder.encode("12345")).roles("ADMIN").build();

        return  new InMemoryUserDetailsManager(teacher,student,admin);
    }

    //authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable().authorizeHttpRequests().requestMatchers("/student/**","/student_department","/add").authenticated().and().httpBasic().and().build();
        return http.csrf().disable()
                .authorizeHttpRequests().anyRequest().authenticated().and().httpBasic().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
