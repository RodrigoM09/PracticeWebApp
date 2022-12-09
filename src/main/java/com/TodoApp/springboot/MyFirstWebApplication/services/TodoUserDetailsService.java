package com.TodoApp.springboot.MyFirstWebApplication.services;

import com.TodoApp.springboot.MyFirstWebApplication.models.Todo;
import com.TodoApp.springboot.MyFirstWebApplication.models.TodoUserDetails;
import com.TodoApp.springboot.MyFirstWebApplication.models.User;
import com.TodoApp.springboot.MyFirstWebApplication.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoUserDetailsService implements UserDetailsService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    public final UserRepository usersDao;

    public TodoUserDetailsService(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User details not found for user:" + username);
        } else {
            return new TodoUserDetails(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
        }
    }
//    public List<Todo> findByUsername(String username){
//        Predicate<? super Todo> predicate =
//                todo -> todo.getUsername().equalsIgnoreCase(username);
//        return todos.stream().filter(predicate).toList();
//    }
//
//    public void addTodo(String username, String description, String targetDate, boolean done){
//        long userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
//        User user = usersDao.findById(userId);
//        Todo todo = new Todo(description,targetDate,done, user);
//        todos.add(todo);
//    }
//
//    public void deleteById(int id){
//        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//        todos.removeIf(predicate);
//    }
//
//    public Todo findById(int id) {
//        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//        Todo todo = todos.stream().filter(predicate).findFirst().get();
//        return todo;
//    }
//
//    public void updateTodo(@Valid Todo todo) {
//        deleteById(todo.getId());
//        todos.add(todo);
//    }
}
