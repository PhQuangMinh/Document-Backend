package com.example.demo.controller;

import com.example.demo.common.dto.CustomReponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    public CustomReponse<User> findById(@PathVariable int id) {
        return new CustomReponse<>(userService.findById(String.valueOf(id)));
    }

    @GetMapping()
    public CustomReponse<Page<User>> findAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortBy) {
        return new CustomReponse<>(userService.findAll(size, page, sortBy));
    }

    @PutMapping()
    public CustomReponse<User> updateUser(@RequestBody User user) {
        return new CustomReponse<>(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }

    @GetMapping("/email")
    public CustomReponse<User> findByEmail(@RequestParam String email) {
        return new CustomReponse<>(userService.findByEmail(email));
    }

}
