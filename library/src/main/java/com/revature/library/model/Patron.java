package com.revature.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patrons")
public class Patron {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "Email is required")
    private String email;

    private LocalDate memberSince;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();// Default constructor required by JPA

    public Patron() {
        this.memberSince = LocalDate.now();
    }

    public Patron(String name, String email) {
        this.name = name;
        this.email = email;
        this.memberSince = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate ms) {
        memberSince = ms;
    }

    public boolean addLoan(Loan l) {
        return loans.add(l);
    }

    public boolean removeLoan(Loan l) {
        return loans.remove(l);
    }
}
