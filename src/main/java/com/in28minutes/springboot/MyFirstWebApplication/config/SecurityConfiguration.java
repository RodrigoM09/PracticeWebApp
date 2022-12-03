//package com.in28minutes.springboot.MyFirstWebApplication.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfiguration {
//
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/todo","/list-todos","/add-todo","/delete-todo", "/update-todo")
//                .authenticated()
//                .antMatchers("/","/login").permitAll()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/list-todos")
//                .and().logout()
//                .and().httpBasic();
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
