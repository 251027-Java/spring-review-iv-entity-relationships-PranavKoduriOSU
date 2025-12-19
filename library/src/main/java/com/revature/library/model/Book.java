package com.revature.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

/**
 * Book Entity - TODO: Complete the annotations
 */
// TODO: Add @Entity annotation
// TODO: Add @Table(name = "books") annotation
@Entity
@Table(name = "books")
public class Book {

    // TODO: Add @Id and @GeneratedValue annotations
    @Id
    @GeneratedValue
    private Long id;

    // TODO: Add @Column(nullable = false) annotation
    @Column(nullable = false)
    @NotBlank(message = "Title is required")
    private String title;

    // TODO: Add @Column(nullable = false) annotation
    @Column(nullable = false)
    @NotBlank(message = "Author is required")
    private String author;

    // TODO: Add @Column(unique = true) annotation
    @Column(unique = true)
    @Pattern(regexp = "^[0-9a-zA-Z-]+$", message = "Invalid ISBN format")
    private String isbn;

    private boolean available = true;

    private LocalDateTime createdAt;

    // Default constructor required by JPA
    public Book() {
        this.createdAt = LocalDateTime.now();
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.createdAt = LocalDateTime.now();
    }

    // TODO: Generate getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Add remaining getters/setters...

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String i) {
        isbn = i;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean a) {
        available = a;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime ca) {
        createdAt = ca;
    }
}