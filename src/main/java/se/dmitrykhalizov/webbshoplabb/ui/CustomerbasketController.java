package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/basket/add/{productId}")
    public String addProductToBasket(@PathVariable int productId,
                                     @RequestParam(defaultValue = "1") int quantity,
                                     @RequestParam int userId) {
        User user = userService.getUser(userId);
        int updatedQuantity = customerbasketService.addProduct(productId, quantity, user);
        Product product = productService.getProductById(productId);
        String productName = product.getName();
        return "redirect:/p/" + productName;
    }

    @GetMapping("/basket")
    public String viewBasket(Model model) {
        User user = userService.getUser();
        List<Customerbasket> customerbasketList = customerbasketService.listCustomerbasket(user);
        double estimatedTotal = 0;
        for (Customerbasket customerbasket : customerbasketList) {
            estimatedTotal += customerbasket.getTotalPrice();
        }
        model.addAttribute("estimatedTotal", estimatedTotal);
        model.addAttribute("customerbasketList", customerbasketList);
        model.addAttribute("user", user);
        return "customerbasket";
    }

    @PostMapping("/basket/update/{productId}/{quantity}")
    public String updateBasketItem(@PathVariable int productId, @PathVariable int quantity, @RequestParam int userId, @RequestParam("quantityToUpdate") int quantityToUpdate, RedirectAttributes redirectAttributes) {
        double subtotal = customerbasketService.updateQuantity(productId, quantityToUpdate, userId);
        redirectAttributes.addFlashAttribute("message", "Quantity updated. New subtotal: " + subtotal);
        return "redirect:/basket";
    }

    @PostMapping("/basket/delete/{productId}")
    public String deleteBasketItem(@PathVariable int productId, @RequestParam int userId, RedirectAttributes redirectAttributes) {
        customerbasketService.deleteProduct(productId, userId);
        redirectAttributes.addFlashAttribute("message", "Product deleted from basket");
        return "redirect:/basket";
    }

}
