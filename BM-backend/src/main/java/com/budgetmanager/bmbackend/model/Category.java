package com.budgetmanager.bmbackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;

    private double limite;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;

    public Category () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limit) {
        this.limite = limit;
    }
}
