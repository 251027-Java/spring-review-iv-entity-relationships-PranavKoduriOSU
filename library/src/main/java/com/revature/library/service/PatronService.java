package com.revature.library.service;

import com.revature.library.model.Book;
import com.revature.library.model.Patron;
import com.revature.library.repository.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatronService {
    private final PatronRepository repo;

    public PatronService(PatronRepository patronRepository) {
        repo = patronRepository;
    }

    public Optional<Patron> findById(Long id) {
        return repo.findById(id);
    }

    public Patron addPatron(Patron patron) {
        return repo.save(patron);
    }
}
