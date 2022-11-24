package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;

    @RequestMapping("listTodos")
    public String listAllTodos(Model model){
       List<Todo> todos = todoService.findByUsername("Rodrigo");
       model.addAttribute("todos", todos);
        return "listTodos";
    }

}
