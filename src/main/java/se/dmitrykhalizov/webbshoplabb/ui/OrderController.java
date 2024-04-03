package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.entity.Orderline;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
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
    @GetMapping("/deliveredorders")
    public String deliveredOrders(Model model) {
        List<Order> deliveredorders = orderService.displayOrdersByUserId(userService.getUser());
        model.addAttribute("deliveredorders", deliveredorders);
        return "completedorders";
    }

    @PostMapping("/products")
    public String makeOrder(@RequestParam("productid") int productid,
                            @RequestParam("quantity") int quantity,
                            Model model) {
        Product product = productService.getProductById(productid);
        String order = orderService.placeOrder(product, quantity);
        model.addAttribute("order", order);
        return "showproductspage";
    }
}
