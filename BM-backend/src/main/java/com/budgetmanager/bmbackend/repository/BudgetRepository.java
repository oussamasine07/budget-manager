package com.budgetmanager.bmbackend.repository;

import com.budgetmanager.bmbackend.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
