package com.in28minutes.springboot.MyFirstWebApplication.controllers;

import com.in28minutes.springboot.MyFirstWebApplication.models.Todo;
import com.in28minutes.springboot.MyFirstWebApplication.repositories.TodoRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }


    private TodoRepository todoRepository;

    // LIST ALL TODOS------------------------------------------------->
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }


//     ADD NEW TODO METHODS ------------------------------------------->
    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username, "", LocalDate.now().plusYears(1),false);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }


    // DELETE TODO METHOD ----------------------------------------->
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
//        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    // UPDATE TODO METHODS ------------------------------>
    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
