package com.in28minutes.springboot.MyFirstWebApplication.services;

import com.in28minutes.springboot.MyFirstWebApplication.models.SpringBlogUserDetails;
import com.in28minutes.springboot.MyFirstWebApplication.models.User;
import com.in28minutes.springboot.MyFirstWebApplication.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringBlogUserDetailsService implements UserDetailsService {

    public final UserRepository usersDao;

    public SpringBlogUserDetailsService(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User details not found for user:" + username);
        } else {
            return new SpringBlogUserDetails(user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
        }
    }
}
