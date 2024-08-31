package com.example.demo.service;

import com.example.demo.model.Author;
import org.springframework.data.domain.Page;

public interface AuthorService {
    Page<Author> findAll(int size, int page, String sortBy);
    Author findById(String id);
    Author save(Author author);
    void deleteById(String id);
}
