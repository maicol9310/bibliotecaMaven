package com.example.bibliotecaMaven.domain.services;

import com.example.bibliotecaMaven.domain.models.Author;
import com.example.bibliotecaMaven.domain.repositories.AuthorRepository;
import com.example.bibliotecaMaven.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        author.setId(id);
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public void deleteAuthor(Long id) {
        if (bookRepository.existsByAuthorId(id)) {
            throw new RuntimeException("Cannot delete author with books");
        }
        authorRepository.deleteById(id);
    }
}