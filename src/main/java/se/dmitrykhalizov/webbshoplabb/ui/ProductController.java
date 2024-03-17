package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.dmitrykhalizov.webbshoplabb.database.Product;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;
import se.dmitrykhalizov.webbshoplabb.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.displayProducts());
        return "showproductspage";
    }

}

