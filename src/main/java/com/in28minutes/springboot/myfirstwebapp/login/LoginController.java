package com.in28minutes.springboot.myfirstwebapp.login;

import jakarta.servlet.http.PushBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String goToLogin(){
        return "login";
    }


    // ADDS ABILITY TO LOG INFO TO TERMINAL------------------------------------>
    //  private Logger logger = LoggerFactory.getLogger(getClass());

   // @RequestMapping("login")
   // public String goToLogin(@RequestParam String name, Model model){
   //     model.addAttribute("name", name);
        // REQUIRED TO VIEW LOG INFORMATION IN CONSOLE------------------------>
       // logger.debug("Request param is {}", name);
   //     return "login";
  //  }
}
