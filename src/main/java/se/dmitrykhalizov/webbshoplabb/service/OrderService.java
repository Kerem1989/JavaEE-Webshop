package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.*;
import se.dmitrykhalizov.webbshoplabb.repository.OrderRepo;
import se.dmitrykhalizov.webbshoplabb.repository.OrderlineRepo;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderlineRepo orderlineRepo;
    @Autowired
    UserService userService;
    @Autowired
    ProductRepo productRepo;

    public List<Order> displayOrders() {
        return orderRepo.findAll();
    }

    public List<Order> displayOrdersByUserId(User user) {
        return orderRepo.findOrdersByUserAndOrderline(user);
    }

    public String placeOrder(Product product, int quantity) {
        User currentUser = userService.getUser();
        if (currentUser == null) {
            return "No user logged in";
        }

        Product selectedProduct = productRepo.findById(product.getProductid()).orElse(null);
        if (selectedProduct == null) {
            return "Product not found";
        }

        LocalDate date = LocalDate.now();

        EnumSelection status = EnumSelection.pending;
        double totalPrice = selectedProduct.getPrice() * quantity;

        Order order = new Order();
        order.setDate(date);
        order.setUser(currentUser);
        order.setStatus(status);
        order.setTotalprice(totalPrice);
        orderRepo.save(order);

        Orderline orderLine = new Orderline();
        orderLine.setOrder(order);
        orderLine.setUser(currentUser);
        orderLine.setProduct(selectedProduct);
        orderLine.setQuantity(quantity);
        orderlineRepo.save(orderLine);

        return "Order placed successfully";
    }
}