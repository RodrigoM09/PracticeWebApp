package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authentication(String username, String password){

        boolean isValidUserName =username.equalsIgnoreCase("Rodrigo");
        boolean isValidPassword =password.equalsIgnoreCase("genius");

        return isValidUserName && isValidPassword;
    }
}
