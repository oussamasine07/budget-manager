package com.budgetmanager.bmbackend.repository;

import com.budgetmanager.bmbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateogoryRepository extends JpaRepository<Category, Long> {
}
