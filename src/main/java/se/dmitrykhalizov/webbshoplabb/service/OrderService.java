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
            // Handle the case when no user is logged in
            return "No user logged in";
        }

        // Retrieve the product from the database based on the product's ID to ensure uniqueness
        Product selectedProduct = productRepo.findById(product.getProductid()).orElse(null);
        if (selectedProduct == null) {
            return "Product not found";
        }

        LocalDate date = LocalDate.now();

        EnumSelection status = EnumSelection.pending;
        double totalPrice = selectedProduct.getPrice() * quantity; // Calculate the total price

        // Create a new order and save it
        Order order = new Order();
        order.setDate(date);
        order.setUser(currentUser); // Set the user field instead of the customer field
        order.setStatus(status);
        order.setTotalprice(totalPrice);
        orderRepo.save(order);

        // Create an orderline for the selected product and save it
        Orderline orderLine = new Orderline();
        orderLine.setOrder(order);
        orderLine.setUser(currentUser);
        orderLine.setProduct(selectedProduct);
        orderLine.setQuantity(quantity);
        orderlineRepo.save(orderLine);

        return "Order placed successfully";
    }
}