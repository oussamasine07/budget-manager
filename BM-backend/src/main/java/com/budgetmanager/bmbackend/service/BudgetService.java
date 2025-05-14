package com.budgetmanager.bmbackend.service;

import com.budgetmanager.bmbackend.model.Budget;
import com.budgetmanager.bmbackend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

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

        return budgetRepository.findAll()
                .stream()
                .filter(budget -> {
                    LocalDate localDate = budget.getDate()
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    return localDate.getMonth() == LocalDate.now().getMonth();
                })
                .collect(Collectors.toList());
    }

    public Budget createBudget ( Budget budget ) {
        return budgetRepository.save( budget );
    }

    public void deleteBudget (Long id) {
        budgetRepository.deleteById(id);
    }

}
