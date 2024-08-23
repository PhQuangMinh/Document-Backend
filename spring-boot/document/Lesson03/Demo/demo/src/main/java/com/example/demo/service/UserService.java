package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> findAll(int size, int page, String sortBy);
    User findById(String id);
    User save(User user);
    void deleteById(String id);
    User findByEmail(String email);
}
