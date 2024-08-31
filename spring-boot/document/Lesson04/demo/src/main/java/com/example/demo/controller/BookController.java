package com.example.demo.controller;

import com.example.demo.common.dto.CustomReponse;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.save(book);
    }

    @GetMapping("/{id}")
    public CustomReponse<Book> findById(@PathVariable int id) {
        return new CustomReponse<>(bookService.findById(String.valueOf(id)));
    }

    @GetMapping()
    public CustomReponse<Page<Book>> findAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortBy) {
        return new CustomReponse<>(bookService.findAll(size, page, sortBy));
    }

    @PutMapping()
    public CustomReponse<Book> updateBook(@RequestBody Book book) {
        return new CustomReponse<>(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
    }
}
