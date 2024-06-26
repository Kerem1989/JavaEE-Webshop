package se.kerem.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kerem.webshop.entity.Category;
import se.kerem.webshop.repository.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public void delete(Integer id) {
        categoryRepo.deleteById(id);
    }

    public List<Category> listAll() {
        return categoryRepo.findAll();
    }

    public List<Category> listEnabled() {
        return categoryRepo.findAllEnabled();
    }

    public Category getCategory(String name) {
        return categoryRepo.getCategoriesByName(name);
    }

    public Category newCategory() {
        Category newCategory = new Category();
        return newCategory;
    }
}
