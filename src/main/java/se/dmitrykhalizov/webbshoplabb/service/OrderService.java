package se.dmitrykhalizov.webbshoplabb.service;

import jakarta.mail.search.SearchTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.*;
import se.dmitrykhalizov.webbshoplabb.repository.OrderRepo;
import se.dmitrykhalizov.webbshoplabb.repository.OrderlineRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderlineRepo orderlineRepo;

    public Order createOrder(User user, List<Customerbasket> customerbasketList) {
        Order order = new Order();
        order.setUser(user);
        order.setDate(LocalDate.now());
        order.setStatus(EnumSelection.pending);
        orderRepo.save(order);

        double total = 0; // Initialize total

        for (Customerbasket customerbasket : customerbasketList) {
            Orderline orderline = new Orderline();
            orderline.setOrder(order);
            orderline.setProduct(customerbasket.getProduct());
            orderline.setQuantity(customerbasket.getQuantity());
            orderline.setUnitPrice(customerbasket.getProduct().getPrice());
            double subTotal = customerbasket.getQuantity() * customerbasket.getProduct().getPrice();
            orderline.setSubTotal(subTotal);
            orderlineRepo.save(orderline); // Save orderline to the database
            total += subTotal; // Add subtotal to total
        }

        order.setTotal(total); // Set total
        orderRepo.save(order); // Save order with orderlines

        return order;
    }

}