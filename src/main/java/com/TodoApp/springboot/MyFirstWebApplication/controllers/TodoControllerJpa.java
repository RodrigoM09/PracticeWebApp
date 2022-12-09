package com.TodoApp.springboot.MyFirstWebApplication.controllers;

import com.TodoApp.springboot.MyFirstWebApplication.models.Todo;
import com.TodoApp.springboot.MyFirstWebApplication.models.User;
import com.TodoApp.springboot.MyFirstWebApplication.repositories.TodoRepository;
import com.TodoApp.springboot.MyFirstWebApplication.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> allTodos = todoDao.findAll();
        model.addAttribute("allTodos", allTodos);
        return "listTodos";
    }


//     ADD NEW TODO METHODS ------------------------------------------->
    @GetMapping("add-todo")
    public String showNewTodoPage(Model model){
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(@ModelAttribute Todo todo) {
        long userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        User user = userDao.findById(userId);
        todo.setUser(user);
        todoDao.save(todo);
        return "redirect:/list-todos";
    }


    // DELETE TODO METHOD ----------------------------------------->
    @RequestMapping("/{id}/delete-todo")
    public String deleteTodo(@PathVariable int id, @ModelAttribute Todo todo){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        todo.setUser(user);
        todoDao.deleteById(id);
        return "redirect:/list-todos";
    }

    // UPDATE TODO METHODS ------------------------------>
    @GetMapping("/{id}/update-todo")
    public String showUpdateTodoPage(@PathVariable int id,Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Todo todo = todoDao.findById(id).get();
        model.addAttribute("todo", todo);
        long usersId = user.getId();
        long todoUserId = todo.getUser().getId();
        if (usersId == todoUserId){
            return "todo";
        }else{
            return "redirect:/Welcome";
        }
    }

    @PostMapping("update-todo")
    public String updateTodo(@ModelAttribute Todo todo) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        todo.setUser(user);
        todoDao.save(todo);
        return "redirect:/list-todos";
    }

    @PostMapping("logout")
    public String logout(){
        return "redirect:/list-todos";
    }
}
