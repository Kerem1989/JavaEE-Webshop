package se.kerem.webshop.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.kerem.webshop.entity.Category;
import se.kerem.webshop.service.CategoryService;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public String listAll(Model model) {
        List<Category> listCategories = service.listAll();
        model.addAttribute("listCategories", listCategories);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String newCategory(Model model) {
        Category category = service.newCategory();
        model.addAttribute("category", category);
        model.addAttribute("pageTitle", "Create New Category");
        return "categoryform";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category, RedirectAttributes redirectAttributes) {
        service.save(category);
        redirectAttributes.addFlashAttribute("message", "The category has been saved successfully.");
        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id, RedirectAttributes redirectAttributes) {
            service.delete(id);
            redirectAttributes.addFlashAttribute("message", "The user ID " + id + " has been deleted successfully");
            return "redirect:/categories";
    }

    @GetMapping("")
    public String viewHomePage(Model model) {
        List<Category> listCategories = service.listEnabled();
        model.addAttribute("listCategories", listCategories);
        return "menupagecustomer";
    }
}

