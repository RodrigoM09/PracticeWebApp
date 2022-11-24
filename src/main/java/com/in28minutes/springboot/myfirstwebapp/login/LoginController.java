package com.in28minutes.springboot.myfirstwebapp.login;

import jakarta.servlet.http.PushBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, @RequestParam String password, Model model){
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        return "Welcome";
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
