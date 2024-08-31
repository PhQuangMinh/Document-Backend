package com.example.demo.controller;

import com.example.demo.common.dto.CustomReponse;
import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public void createAuthor(@RequestBody Author author) {
        authorService.save(author);
    }

    @GetMapping("/{id}")
    public CustomReponse<Author> findById(@PathVariable int id) {
        return new CustomReponse<>(authorService.findById(String.valueOf(id)));
    }

    @GetMapping()
    public CustomReponse<Page<Author>> findAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortBy) {
        return new CustomReponse<>(authorService.findAll(size, page, sortBy));
    }

    @PutMapping()
    public CustomReponse<Author> updateAuthor(@RequestBody Author author) {
        return new CustomReponse<>(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable String id) {
        authorService.deleteById(id);
    }
}
