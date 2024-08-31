package com.example.demo.service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.common.utils.PageableUtils;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Page<Author> findAll(int size, int page, String sortBy) {
        Pageable pageable = PageableUtils.createPageable(size, page, sortBy);
        return authorRepository.findAll(pageable);
    }

    @Override
    public Author findById(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isEmpty()) throw new NotFoundException("Author not found - " + id);
        return author.get();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(String id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isEmpty()) throw new NotFoundException("Author not found - " + id);
        authorRepository.delete(author.get());
    }
}
