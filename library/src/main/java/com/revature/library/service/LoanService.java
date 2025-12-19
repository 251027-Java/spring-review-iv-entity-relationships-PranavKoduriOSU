package com.revature.library.service;

import com.revature.library.exception.BookNotFoundException;
import com.revature.library.exception.LoanNotFoundException;
import com.revature.library.exception.PatronNotFoundException;
import com.revature.library.model.Book;
import com.revature.library.model.Loan;
import com.revature.library.model.Patron;
import com.revature.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository repo;
    private final BookService bServ;
    private final PatronService pServ;

    public LoanService(LoanRepository loanRepository, BookService bookService, PatronService patronService) {
        repo = loanRepository;
        bServ = bookService;
        pServ = patronService;
    }

    public Loan createLoan(Long bookId, Long patronId){
        Book book = bServ.findById(bookId).orElseThrow(() -> new BookNotFoundException(String.format("Book ID=%d not found.", bookId)));
        Patron patron = pServ.findById(patronId).orElseThrow(() -> new PatronNotFoundException(String.format("Patron ID=%d not found.", patronId)));

        return repo.save(new Loan(book, patron));
    }

    public Loan returnLoan(Long loanId){
        Loan loan = repo.findById(loanId).orElseThrow(() -> new LoanNotFoundException(String.format("Loan ID=%d not found.", loanId)));
        loan.setReturnDate(LocalDate.now());

        return repo.save(loan);
    }

    public List<Loan> getActiveLoans(){
        return repo.findAllByReturnDateIsNull();
    }

    public List<Loan> getLoansByPatron(Long patronId){
        return repo.findAllByPatronId(patronId);
    }
}
