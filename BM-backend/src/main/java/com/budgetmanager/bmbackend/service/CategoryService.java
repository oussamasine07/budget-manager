package com.budgetmanager.bmbackend.service;

import com.budgetmanager.bmbackend.model.Category;
import com.budgetmanager.bmbackend.repository.CateogoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    // dependency injection
    private final CateogoryRepository cateogoryRepository;

    @Autowired
    public CategoryService (
            final CateogoryRepository cateogoryRepository
    ) {
        this.cateogoryRepository = cateogoryRepository;
    }

    public List<Category> getAllCategories () {
        return cateogoryRepository.findAll();
    }

    public Category createCategory ( Category category ) {
        return cateogoryRepository.save(category);
    }

    public Category updateCategory ( Long id, Category category ) {
        Category updatedCategory = cateogoryRepository.findById(id).orElseThrow();

        updatedCategory.setName(category.getName());
        updatedCategory.setLimite(category.getLimite());

        return cateogoryRepository.save(updatedCategory);
    }

    public void deleteCategory (Long id) {
        cateogoryRepository.deleteById(id);
    }
}
