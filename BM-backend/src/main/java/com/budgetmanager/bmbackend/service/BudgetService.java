package com.budgetmanager.bmbackend.service;

import com.budgetmanager.bmbackend.model.Budget;
import com.budgetmanager.bmbackend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService (
            final BudgetRepository budgetRepository
    ) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> getAllBudgets () {
        return budgetRepository.findAll();
    }

    public Budget createBudget ( Budget budget ) {
        return budgetRepository.save( budget );
    }

}
