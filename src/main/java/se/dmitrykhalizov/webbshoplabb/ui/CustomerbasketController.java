package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/customerbaskets")
    public String getCustomerbaskets(Model model) {
        model.addAttribute("customerbaskets", customerbasketService.getAllCustomerbaskets());
        return "showcustomerbasketspage";
    }

    @GetMapping("/deletecustomerbasket")
    public String showDeleteCustomerbasketPage() {
        return "deletecustomerbasketpage";
    }

    @PostMapping("deletecustomerbasket")
    public String deleteCustomerbasket(@RequestParam int id, Model model) {
        customerbasketService.deleteCustomerbasket(id);
        model.addAttribute("message", "Customer basket was deleted");
        return "deletecustomerbasketpage";
    }

    @GetMapping("/addcustomerbasket")
    public String showAddCustomerBasketPage(Model model) {
        model.addAttribute("resultAddCustomerbasket", "");
        return "addcustomerbasketpage";
    }

    @PostMapping("/addcustomerbasket")
    public String addCustomerBasket(@RequestParam int customerbasketid, Model model) {
        User user = userService.getUser();
        Customerbasket customerbasket = new Customerbasket(customerbasketid, user, 0, 0.0);
        customerbasketService.createCustomerbasket(customerbasket);
        model.addAttribute("resultAddCustomerbasket", "Customer basket added successfully");
        return "addcustomerbasketpage";
    }
}
