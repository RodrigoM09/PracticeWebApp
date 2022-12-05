package com.in28minutes.springboot.MyFirstWebApplication.controllers;

import com.in28minutes.springboot.MyFirstWebApplication.models.Todo;
import com.in28minutes.springboot.MyFirstWebApplication.models.User;
import com.in28minutes.springboot.MyFirstWebApplication.repositories.TodoRepository;
import com.in28minutes.springboot.MyFirstWebApplication.repositories.UserRepository;
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
    private final UserRepository userDao;
    private final TodoRepository todoDao;

    public TodoControllerJpa(UserRepository userDao, TodoRepository todoDao) {
        super();
        this.userDao = userDao;
        this.todoDao = todoDao;
    }



    // LIST ALL TODOS------------------------------------------------->
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoDao.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }


//     ADD NEW TODO METHODS ------------------------------------------->
    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username, "", LocalDate.now().plusYears(1),false);
        model.put("todo", todo);
//        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(@Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        long userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        User user = userDao.findById(userId);
        todo.setUser(user);
        todoDao.save(todo);
        return "redirect:list-todos";
    }


    // DELETE TODO METHOD ----------------------------------------->
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoDao.deleteById(id);
//        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    // UPDATE TODO METHODS ------------------------------>
    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
        Todo todo = todoDao.findById(id).get();
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
        todoDao.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
