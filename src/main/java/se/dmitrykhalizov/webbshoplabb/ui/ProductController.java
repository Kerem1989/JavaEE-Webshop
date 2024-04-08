package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping ("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("result", "");
        return "addproductpage";

    }





}

