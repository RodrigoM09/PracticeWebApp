package com.in28minutes.springboot.myfirstwebapp.todo;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
