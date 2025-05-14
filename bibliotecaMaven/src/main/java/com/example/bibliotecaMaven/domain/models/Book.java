package com.example.bibliotecaMaven.domain.models;

public class Book {
    private Long id;
    private String title;
    private String description;
    private Long authorId;
    private String publicationDate;


    public Book() {}

    public Book(Long id, String title, String description, Long authorId, String publicationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.authorId = authorId;
        this.publicationDate = publicationDate;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
    public String getPublicationDate() { return publicationDate; }
    public void setPublicationDate(String publicationDate) { this.publicationDate = publicationDate; }
}