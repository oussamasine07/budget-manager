package com.budgetmanager.bmbackend.controller;

import com.budgetmanager.bmbackend.dto.TransactionDTO;
import com.budgetmanager.bmbackend.model.Transaction;
import com.budgetmanager.bmbackend.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    // inject Transcation service

    private final TransactionService transactionService;

    public TransactionController (
            final TransactionService transactionService
    ) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> transactions () {
        return transactionService.listTransactions();
    }

    // all controller methods (CRUD)
    @PostMapping
    public Transaction create(@RequestBody TransactionDTO transaction) {
        System.out.println();
        return transactionService.makeTransaction(transaction);
    }
}














