package com.example.bibliotecaMaven.domain.services;

import com.example.bibliotecaMaven.domain.models.Book;
import com.example.bibliotecaMaven.domain.repositories.AuthorRepository;
import com.example.bibliotecaMaven.domain.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(Book book) {
        if (!authorRepository.existsById(book.getAuthorId())) {
            throw new RuntimeException("Author not found");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}