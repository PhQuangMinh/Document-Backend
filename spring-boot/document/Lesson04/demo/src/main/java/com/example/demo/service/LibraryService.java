package com.example.demo.service;

import com.example.demo.model.Library;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;

public interface LibraryService {
    Page<Library> findAll(int size, int page, String sortBy);
    Library findById(String id);
    Library save(Library library);
    void deleteById(String id);
}
