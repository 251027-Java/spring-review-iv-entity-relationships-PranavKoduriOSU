package com.revature.library.service;

import com.revature.library.exception.BookNotAvailableException;
import com.revature.library.exception.BookNotFoundException;
import com.revature.library.model.Book;
import com.revature.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BookService - TODO: Implement using constructor injection
 */
@Service
public class BookService {

    // TODO: Declare a final BookRepository field
    private final BookRepository repo;

    // TODO: Create constructor that accepts BookRepository
     public BookService(BookRepository bookRepository) {
        repo = bookRepository;
     }

    public List<Book> getAllBooks() {
        // TODO: Return all books from repository
        return repo.findAll();
    }

    public Optional<Book> findById(Long id) {
        // TODO: Find book by ID
        return repo.findById(id);
    }

    public Book addBook(Book book) {
        // TODO: Save and return the book
        return repo.save(book);
    }

    public Book checkoutBook(Long bookId) {
        // TODO: Find book, set available = false, save and return
        Book book = repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(String.format("Book ID=%d not found.", bookId)));

        if (!book.getAvailable()) throw new BookNotAvailableException(String.format("Book ID=%d not available.", bookId));
        book.setAvailable(false);

        return repo.save(book);
    }

    public Book returnBook(Long bookId) {
        // TODO: Find book, set available = true, save and return
        Book book = repo.findById(bookId).orElseThrow(() -> new BookNotFoundException(String.format("Book ID=%d not found.", bookId)));
        book.setAvailable(true);

        return repo.save(book);
    }
}