package com.example.demo.controller;

import com.example.demo.common.dto.CustomReponse;
import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/libraries")
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping
    public void createLibrary(@RequestBody Library library) {
        libraryService.save(library);
    }

    @GetMapping("/{id}")
    public CustomReponse<Library> findById(@PathVariable int id) {
        return new CustomReponse<>(libraryService.findById(String.valueOf(id)));
    }

    @GetMapping()
    public CustomReponse<Page<Library>> findAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "id") String sortBy) {
        return new CustomReponse<>(libraryService.findAll(size, page, sortBy));
    }

    @PutMapping()
    public CustomReponse<Library> updateLibrary(@RequestBody Library library) {
        return new CustomReponse<>(libraryService.save(library));
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable String id) {
        libraryService.deleteById(id);
    }
}
