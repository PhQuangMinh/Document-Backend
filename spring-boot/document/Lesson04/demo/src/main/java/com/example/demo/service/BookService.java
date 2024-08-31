package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<Book> findAll(int size, int page, String sortBy);
    Book findById(String id);
    Book save(Book book);
    void deleteById(String id);
}
