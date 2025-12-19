package com.revature.library;

import com.revature.library.model.Book;
import com.revature.library.repository.BookRepository;
import com.revature.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedData (BookRepository repo, BookService serv) {
        return args -> {
            Book[] books = {
                    new Book("Clean Code", "Robert Martin", "isbn1"),
                    new Book("The Pragmatic Programmer", "David Thomas", "isbn2"),
                    new Book("Design Patterns", "Gang of Four", "isbn3"),
                    new Book("Effective Java", "Joshua Bloch", "isbn4"),
                    new Book("Spring in Action", "Craig Walls", "isbn5"),
            };

            for (Book b : books) repo.save(b);
        };
    }
}
