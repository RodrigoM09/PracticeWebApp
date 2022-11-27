package com.in28minutes.springboot.myfirstwebapp.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

        @Bean
        public  InMemoryUserDetailsManager createUserDetailsManager(){
             UserDetails userDetails = User.withDefaultPasswordEncoder()
            .username("Rodrigo")
            .password("genius")
            .roles("USER", "ADMIN")
            .build();
            return new InMemoryUserDetailsManager(userDetails);
        }
}
