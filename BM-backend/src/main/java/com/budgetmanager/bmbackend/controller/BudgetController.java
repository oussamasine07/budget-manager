package com.budgetmanager.bmbackend.controller;

import com.budgetmanager.bmbackend.model.Budget;
import com.budgetmanager.bmbackend.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController (
            final BudgetService budgetService
    ) {
        this.budgetService = budgetService;
    }


    @GetMapping
    public List<Budget> index () {

        System.out.println(System.getenv("MYSQL_PASSWORD"));
        return budgetService.getAllBudgets();
    }

}
