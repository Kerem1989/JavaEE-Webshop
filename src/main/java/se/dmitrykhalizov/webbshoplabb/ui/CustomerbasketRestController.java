package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.CustomerbasketService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

@RestController
public class CustomerbasketRestController {
    @Autowired
    private CustomerbasketService customerbasketService;
    @Autowired
    private UserService userService;

    @PostMapping("/basket/add/{productid}/{quantity}/{userid}")
    public String addProductToBasket(@PathVariable(name="productid") int productid, @PathVariable(name="quantity") int quantity, @PathVariable(name="userid") int userid){
        User user = userService.getUser(userid);
        int updatedQuantity = customerbasketService.addProduct(productid, quantity, user);
        return "Product added to basket. New quantity: " + updatedQuantity;
    }
}
