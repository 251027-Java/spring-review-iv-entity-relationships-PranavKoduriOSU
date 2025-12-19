package com.revature.library.controller;

import com.revature.library.exception.BookNotFoundException;
import com.revature.library.model.Book;
import com.revature.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BookController - TODO: Complete the REST endpoints
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    // TODO: Add BookService with constructor injection
    private final BookService serv;

    // TODO: Create constructor
     public BookController(BookService bookService) {
        serv = bookService;
     }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        // TODO: Return all books
        return serv.getAllBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable Long id) {
        // TODO: Return book by ID, handle not found case
        return serv.findById(id).orElseThrow(() -> new BookNotFoundException(String.format("Book ID=%d not found.", id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@Valid @RequestBody Book book) {
        // TODO: Add and return the new book
        return serv.addBook(book);
    }

    @PutMapping("/{id}/checkout")
    @ResponseStatus(HttpStatus.OK)
    public Book checkoutBook(@PathVariable Long id) {
        // TODO: Checkout the book
        return serv.checkoutBook(id);
    }

    @PutMapping("/{id}/return")
    @ResponseStatus(HttpStatus.OK)
    public Book returnBook(@PathVariable Long id) {
        // TODO: Return the book
        return serv.returnBook(id);
    }
}