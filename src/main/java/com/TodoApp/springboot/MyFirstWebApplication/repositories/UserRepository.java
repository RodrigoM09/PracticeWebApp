package com.TodoApp.springboot.MyFirstWebApplication.repositories;

import com.TodoApp.springboot.MyFirstWebApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
}
