package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are you learning today?";
    }

    @GetMapping("say-hello-html")
    public String sayHelloHtml(){
        return "/say-hello-html";
    }

}
