package com.example.bibliotecaMaven.domain.repositories;

import com.example.bibliotecaMaven.domain.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(Long id);
    List<Author> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}