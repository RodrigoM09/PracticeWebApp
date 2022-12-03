package com.in28minutes.springboot.MyFirstWebApplication.repositories;

import com.in28minutes.springboot.MyFirstWebApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
}
