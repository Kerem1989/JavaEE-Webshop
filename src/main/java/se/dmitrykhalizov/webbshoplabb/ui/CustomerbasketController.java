package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.CustomerbasketService;
import se.dmitrykhalizov.webbshoplabb.service.ProductService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

import java.util.List;

@Controller
public class CustomerbasketController {

    @Autowired
    CustomerbasketService customerbasketService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @PostMapping("/basket/add")
    public String addProductToBasket(@RequestParam int productId, @RequestParam int quantity, @RequestParam int userId, RedirectAttributes redirectAttributes){
        User user = userService.getUser(userId);
        int updatedQuantity = customerbasketService.addProduct(productId, quantity, user);
        redirectAttributes.addFlashAttribute("message", "Product added to basket. New quantity: " + updatedQuantity);
        Product product = productService.getProductById(productId);
        String productName = product.getName();
        return "redirect:/p/" + productName;
    }

    @GetMapping("/basket")
    public String viewBasket(Model model, @RequestParam int userId){
        User user = userService.getUser(userId);
        List<Customerbasket> listBasket = customerbasketService.listCustomerbasket(user);
        model.addAttribute("listBasket", listBasket);
        return "basket/customerbasket";
    }
}
