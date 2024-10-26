package com.example.springsecurity.service;

import com.example.springsecurity.model.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    Page<User> findAll(int size, int page, String sortBy);
    User findById(String id);
    User save(User user);
    void deleteById(String id);
    UserDetails loadUserByUserName(String userName);
}
