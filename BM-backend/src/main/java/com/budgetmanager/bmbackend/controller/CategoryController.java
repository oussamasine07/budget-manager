package com.budgetmanager.bmbackend.controller;

import com.budgetmanager.bmbackend.model.Category;
import com.budgetmanager.bmbackend.repository.CateogoryRepository;
import com.budgetmanager.bmbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    // inject Category service

    // all controller methods (CRUD)


    @Autowired
    private CateogoryRepository cateogoryRepository;
//get all categieis
    @GetMapping
    public List<Category> getAllCategories() {
        return cateogoryRepository.findAll();
    }
//    save category

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return cateogoryRepository.save(category);
    }

//    updat category

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category category) {
        return (ResponseEntity<Category>) cateogoryRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//    delet category
    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable long id) {
        if (cateogoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cateogoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
