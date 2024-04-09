package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.dmitrykhalizov.webbshoplabb.entity.Category;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.service.CategoryService;
import se.dmitrykhalizov.webbshoplabb.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/products")
    public String listAll(Model model) {
        List<Product> listProducts = productService.listAll();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }

    @GetMapping("/products/new")
    public String newProduct(Model model) {
        List<Category> listCategories = categoryService.listAll();
        Product product = new Product();
        product.setInStock(true);
        model.addAttribute("product", product);
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("pageTitle", "Create New Product");
        return "productform";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{productid}/enabled/{status}")
    public String updateInStockStatus(@PathVariable("productid") Integer productid, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
        productService.updateInStockStatus(productid, enabled);
        String status = enabled ? "in stock" : "out of stock";
        String message = "The Product ID " + productid + " is now " + status;
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{productid}")
    public String deleteProduct(@PathVariable("productid") int productId, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(productId);
        String message = "The Product ID " + productId + " has been deleted successfully";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/products";
    }

    @GetMapping("/c/{name}")
    public String viewCategory(@PathVariable("name") String name, Model model) {
        Category category = categoryService.getCategory(name);
        List<Product> listProducts = productService.findProductByCategory(name);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("pageTitle", category.getName());
        return "productsbycategory";
    }
}