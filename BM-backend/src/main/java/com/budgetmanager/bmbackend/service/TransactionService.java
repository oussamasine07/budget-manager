package com.budgetmanager.bmbackend.service;

import com.budgetmanager.bmbackend.dto.TransactionDTO;
import com.budgetmanager.bmbackend.model.Budget;
import com.budgetmanager.bmbackend.model.Category;
import com.budgetmanager.bmbackend.model.Transaction;
import com.budgetmanager.bmbackend.repository.BudgetRepository;
import com.budgetmanager.bmbackend.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TransactionService {

    private final BudgetRepository budgetRepository;
    private final TransactionRepository transactionRepository;
    private final BudgetService budgetService;
    private final CategoryService categoryService;

    public TransactionService (
            final BudgetRepository budgetRepository,
            final TransactionRepository transactionRepository,
            final BudgetService budgetService,
            final CategoryService categoryService
    ) {
        this.budgetRepository = budgetRepository;
        this.transactionRepository = transactionRepository;
        this.budgetService = budgetService;
        this.categoryService = categoryService;
    }

    public List<Transaction> listTransactions () {
        return transactionRepository.findAll();
    }

    // make transaction
    public Transaction makeTransaction (TransactionDTO transactionDTO) {

        Budget budget = budgetService.getBudgetById(transactionDTO.budget_id());
        Category category = categoryService.getCategoryById(transactionDTO.category_id());
        Transaction transaction = new Transaction();

        switch (transactionDTO.type()){
            case "revenu":
                budget.setAmount(budget.getAmount() + transactionDTO.amount());
                budgetRepository.save(budget);
                transaction.setDescription(transactionDTO.description());
                transaction.setType(transactionDTO.type());
                transaction.setAmount(transactionDTO.amount());
                transaction.setBudget(budget);
                return transactionRepository.save(transaction);
            case "expence":

                if (budget.getAmount() < transactionDTO.amount()) {
                    // throw error
                    throw new Error("unsufficient funds");
                } else {
                    if (transactionDTO.amount() > category.getLimite()) {
                        throw new Error("unsufficient budget funds");
                    } else {
                        budget.setAmount(budget.getAmount() - transaction.getAmount());
                        budgetRepository.save(budget);

                        transaction.setDescription(transactionDTO.description());
                        transaction.setType(transactionDTO.type());
                        transaction.setAmount(transactionDTO.amount());

                        transaction.setBudget(budget);
                        transaction.setCategory(category);
                        return transactionRepository.save(transaction);
                    }
                }
        }

        return null;
    }

}
