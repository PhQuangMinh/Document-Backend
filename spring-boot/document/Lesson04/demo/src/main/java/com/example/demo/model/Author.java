package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "biography")
    private String biography;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private List<Library> libraries;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnore
    private List<Book> books;
}

