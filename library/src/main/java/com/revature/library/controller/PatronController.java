package com.revature.library.controller;

import com.revature.library.exception.PatronNotFoundException;
import com.revature.library.model.Patron;
import com.revature.library.service.PatronService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronService serv;

    public PatronController(PatronService patronService) {
        serv = patronService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patron addPatron(@RequestBody Patron patron) {
        return serv.addPatron(patron);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patron getById(@PathVariable Long id) {
        return serv.findById(id).orElseThrow(() -> new PatronNotFoundException(String.format("Patron ID=%d not found.", id)));
    }
}
