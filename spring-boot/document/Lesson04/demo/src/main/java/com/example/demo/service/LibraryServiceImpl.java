package com.example.demo.service;

import com.example.demo.common.exception.NotFoundException;
import com.example.demo.common.utils.PageableUtils;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.model.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;

    @Override
    public Page<Library> findAll(int size, int page, String sortBy) {
        Pageable pageable = PageableUtils.createPageable(size, page, sortBy);
        return libraryRepository.findAll(pageable);
    }

    @Override
    public Library findById(String id) {
        Optional<Library> library = libraryRepository.findById(id);
        if (library.isEmpty()) throw new NotFoundException("Library not found - " + id);
        return library.get();
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void deleteById(String id) {
        Optional<Library> library = libraryRepository.findById(id);
        if (library.isEmpty()) throw new NotFoundException("Library not found - " + id);
        libraryRepository.delete(library.get());
    }

}
