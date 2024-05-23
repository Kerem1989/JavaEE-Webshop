package se.kerem.webshop.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.kerem.webshop.entity.*;
import se.kerem.webshop.service.CustomerbasketService;
import se.kerem.webshop.service.OrderService;
import se.kerem.webshop.service.ProductService;
import se.kerem.webshop.service.UserService;
import se.kerem.webshop.entity.Customerbasket;
import se.kerem.webshop.entity.Order;
import se.kerem.webshop.entity.User;

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
        customerbasketService.deleteActiveCustomerbasket(user);
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
