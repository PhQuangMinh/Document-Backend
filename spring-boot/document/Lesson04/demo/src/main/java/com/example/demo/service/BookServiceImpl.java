package com.example.demo.service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.common.utils.PageableUtils;
import com.example.demo.repository.BookRepository;
import com.example.demo.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Page<Book> findAll(int size, int page, String sortBy) {
        Pageable pageable = PageableUtils.createPageable(size, page, sortBy);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new NotFoundException("Book not found - " + id);
        return book.get();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) throw new NotFoundException("Book not found - " + id);
        bookRepository.delete(book.get());
    }

}
