package com.budgetmanager.bmbackend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private String type;

    private String description;

    private double amount;
//pls transaction peut avoir même budget
    @ManyToOne
    private Budget budget;

    public Transaction () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
