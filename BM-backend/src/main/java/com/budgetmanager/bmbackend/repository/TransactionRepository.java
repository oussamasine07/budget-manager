package com.budgetmanager.bmbackend.repository;

import com.budgetmanager.bmbackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
