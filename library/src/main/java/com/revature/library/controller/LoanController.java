package com.revature.library.controller;

import com.revature.library.model.Book;
import com.revature.library.model.Loan;
import com.revature.library.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    private final LoanService serv;

    public LoanController(LoanService loanService) {
        serv = loanService;
    }

    @PostMapping("/loans")
    @ResponseStatus(HttpStatus.CREATED)
    public Loan createLoan(@RequestParam Long bookId, @RequestParam Long patronId) {
        return serv.createLoan(bookId, patronId);
    }

    @PutMapping("/loans/{id}/return")
    @ResponseStatus(HttpStatus.OK)
    public Loan returnLoan(@PathVariable Long id) {
        return serv.returnLoan(id);
    }

    @GetMapping("/loans/active")
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> getActiveLoans() {
        return serv.getActiveLoans();
    }

    @GetMapping("/patrons/{id}/loans")
    @ResponseStatus(HttpStatus.OK)
    public List<Loan> getLoansByPatron(@PathVariable Long id) {
        return serv.getLoansByPatron(id);
    }
}
