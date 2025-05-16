package com.budgetmanager.bmbackend.dto;

public record TransactionDTO(
        String type,
        String description,
        double amount,
        Long category_id,
        Long budget_id
) {

}
