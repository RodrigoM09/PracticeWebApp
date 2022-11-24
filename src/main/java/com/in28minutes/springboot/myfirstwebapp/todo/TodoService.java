package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1,"Rodrigo","Learn MySQL", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(2,"Rodrigo","Learn Java", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(3,"Rodrigo","Learn Python", LocalDate.now().plusMonths(3), false));
        todos.add(new Todo(4,"Rodrigo","Learn DevOps", LocalDate.now().plusYears(1), false));
    }
    public List<Todo> findByUsername(String username){
        return todos;
    }
}
