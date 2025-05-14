package com.example.bibliotecaMaven.domain.repositories;

import com.example.bibliotecaMaven.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    boolean existsById(Long id);
    void deleteById(Long id);
    boolean existsByAuthorId(Long authorId);
}