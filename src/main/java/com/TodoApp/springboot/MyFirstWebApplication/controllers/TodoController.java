//package com.in28minutes.springboot.MyFirstWebApplication.controllers;
//
//import com.in28minutes.springboot.MyFirstWebApplication.models.Todo;
//import com.in28minutes.springboot.MyFirstWebApplication.services.TodoUserDetailsService;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.time.LocalDate;
//import java.util.List;
//
////@Controller
//@SessionAttributes("name")
//public class TodoController {
//    public TodoController(TodoUserDetailsService todoService) {
//        super();
//        this.todoService = todoService;
//    }
//
//    private TodoUserDetailsService todoService;
//
//    // LIST ALL TODOS------------------------------------------------->
//    @RequestMapping("list-todos")
//    public String listAllTodos(ModelMap model){
//        String username = getLoggedInUsername(model);
//       List<Todo> todos = todoService.findByUsername(username);
//       model.addAttribute("todos", todos);
//        return "listTodos";
//    }
//
//
////     ADD NEW TODO METHODS ------------------------------------------->
//    @GetMapping("add-todo")
//    public String showNewTodoPage(ModelMap model){
//        String username = getLoggedInUsername(model);
//        Todo todo = new Todo(0,username, "", LocalDate.now().plusYears(1),false);
//        model.put("todo", todo);
//        return "todo";
//    }
//
//    @PostMapping("add-todo")
//    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
//        if(result.hasErrors()){
//            return "redirect:todo";
//        }
//        String username = getLoggedInUsername(model);
//        todoService.addTodo(username, todo.getDescription(),
//                todo.getTargetDate(), false);
//        return "redirect:list-todos";
//    }
//
//
//    // DELETE TODO METHOD ----------------------------------------->
//    @RequestMapping("delete-todo")
//    public String deleteTodo(@RequestParam int id){
//        todoService.deleteById(id);
//        return "redirect:list-todos";
//    }
//
//    // UPDATE TODO METHODS ------------------------------>
//    @GetMapping("update-todo")
//    public String showUpdateTodoPage(@RequestParam int id,ModelMap model){
//        Todo todo = todoService.findById(id);
//        model.addAttribute("todo", todo);
//        return "todo";
//    }
//
//    @PostMapping("update-todo")
//    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
//        if(result.hasErrors()){
//            return "todo";
//        }
//        String username = getLoggedInUsername(model);
//        todo.setUsername(username);
//        todoService.updateTodo(todo);
//        return "redirect:list-todos";
//    }
//
//    private String getLoggedInUsername(ModelMap model){
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//        return authentication.getName();
//    }
//}
