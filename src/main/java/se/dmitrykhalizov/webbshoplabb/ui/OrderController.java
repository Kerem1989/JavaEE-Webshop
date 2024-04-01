package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.service.OrderService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;
    @GetMapping("/deliveredorders")
    public String deliveredOrders(Model model) {
        List<Order> deliveredorders = orderService.displayOrdersByUserId(userService.getUser().getUserid());
        model.addAttribute("deliveredorders", deliveredorders);
        return "menupageformercustomer";
    }
}
