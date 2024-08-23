package com.example.demo.service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.common.utils.PageableUtils;
import com.example.demo.dao.repository.UserRepository;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;


    @Override
    public Page<User> findAll(int size, int page, String sortBy) {
        Pageable pageable = PageableUtils.createPageable(size, page, sortBy);
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new NotFoundException("User not found - " + id);
        return user.get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new NotFoundException("User not found - " + id);
        userRepository.delete(user.get());
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) throw new NotFoundException("User not found - " + email);
        return user;
    }

}
