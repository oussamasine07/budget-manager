package com.budgetmanager.bmbackend.controller;

import com.budgetmanager.bmbackend.model.Category;
import com.budgetmanager.bmbackend.repository.CateogoryRepository;
import com.budgetmanager.bmbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController (
            final CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category category) {
//        return (ResponseEntity<Category>) cateogoryRepository
//              .findById(id)
//              .map(ResponseEntity::ok)
//              .orElse(ResponseEntity.notFound().build());
//
//        return categoryService.updateCategory(id, category);
//    }

    @PutMapping("/{id}")
    public Category update (@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory (@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Category> deleteCategory(@PathVariable long id) {
//        if (cateogoryRepository.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        cateogoryRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

}
