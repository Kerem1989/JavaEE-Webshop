package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String createOrder(@PathVariable int userId, Model model) {
        User user = userService.getUser(userId);
        List<Customerbasket> customerbasketList = customerbasketService.listCustomerbasket(user);
        Order orderList = orderService.createOrder(user, customerbasketList);
        model.addAttribute("orderList", orderList);
        customerbasketService.deletCustomerbasket(user);
        return "orderconfirmation";
    }

    @GetMapping("/order")
    public String listOrders(Model model) {
        List<Order> orderList = orderService.findAll();
        model.addAttribute("orderList", orderList);
        return "orders";
    }

    @GetMapping("/order/{orderid}/status/{status}")
    public String updateOrderStatus(@PathVariable("orderid") Integer orderid, @PathVariable("status") boolean status, RedirectAttributes redirectAttributes) {
        orderService.changeStatus(orderid, status);
        String statusMessage = status ? "in stock" : "out of stock";
        redirectAttributes.addFlashAttribute("message", statusMessage);
        return "redirect:/order";
    }
}
