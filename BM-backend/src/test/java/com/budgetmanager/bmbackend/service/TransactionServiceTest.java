package com.budgetmanager.bmbackend.service;

import com.budgetmanager.bmbackend.model.Category;
import com.budgetmanager.bmbackend.repository.CateogoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    CateogoryRepository cateogoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    void addCategorySuccessfully () {
        Category category = new Category();
        category.setName("travel");
        category.setLimite(1000);
        Mockito.when(cateogoryRepository.save(category)).thenReturn(category);
        Category addedCategpry = categoryService.createCategory(category);

        // start testing
        Assertions.assertEquals(category.getId(), addedCategpry.getId());
    }
}
