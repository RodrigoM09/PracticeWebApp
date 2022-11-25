package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;

    @GetMapping("list-todos")
    public String listAllTodos(Model model){
       List<Todo> todos = todoService.findByUsername("Rodrigo");
       model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(){
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, Model model) {
        String username = (String)model.get("name");
        todoService.addTodo(username, description,
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
