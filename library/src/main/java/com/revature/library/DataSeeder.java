package com.revature.library;

import com.revature.library.model.Book;
import com.revature.library.model.Loan;
import com.revature.library.model.Patron;
import com.revature.library.repository.BookRepository;
import com.revature.library.repository.LoanRepository;
import com.revature.library.repository.PatronRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner seedData (BookRepository bRepo, PatronRepository pRepo, LoanRepository lRepo) {
        return args -> {
            Book[] books = {
                    new Book("Clean Code", "Robert Martin", "isbn1"),
                    new Book("The Pragmatic Programmer", "David Thomas", "isbn2"),
                    new Book("Design Patterns", "Gang of Four", "isbn3"),
                    new Book("Effective Java", "Joshua Bloch", "isbn4"),
                    new Book("Spring in Action", "Craig Walls", "isbn5"),
            };
            for (Book b : books) bRepo.save(b);

            Patron[] patrons = {
                    new Patron("aaa", "a@patron.com"),
                    new Patron("bbb", "b@patron.com"),
                    new Patron("ccc", "c@patron.com"),
                    new Patron("ddd", "d@patron.com"),
                    new Patron("eee", "e@patron.com"),
            };
            for (Patron p : patrons) pRepo.save(p);

            Loan[] loans = {
                    new Loan(books[0], patrons[0]),
                    new Loan(books[0], patrons[1]),
                    new Loan(books[1], patrons[0]),
                    new Loan(books[1], patrons[1]),
                    new Loan(books[2], patrons[2]),
            };
            for (Loan l : loans) lRepo.save(l);
        };
    }
}
