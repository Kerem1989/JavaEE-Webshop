package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.dmitrykhalizov.webbshoplabb.entity.*;
import se.dmitrykhalizov.webbshoplabb.service.CustomerbasketService;
import se.dmitrykhalizov.webbshoplabb.service.OrderService;
import se.dmitrykhalizov.webbshoplabb.service.ProductService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

import java.lang.constant.PackageDesc;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    CustomerbasketService customerbasketService;


    @PostMapping("/order/create/{userId}")
    public String createOrder(@PathVariable int userId) {
        User user = userService.getUser(userId);
        List<Customerbasket> customerbasketList = customerbasketService.listCustomerbasket(user);
        Order order = orderService.createOrder(user, customerbasketList);
        return "showloginpage";
    }
}
