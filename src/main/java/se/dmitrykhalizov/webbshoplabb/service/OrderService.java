package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.repository.OrderRepo;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> displayOrders() {
        return orderRepo.findAll();
    }

    public List <Order> displayOrdersByUserId(int userId) {
        return orderRepo.findOrdersByUser(userId);
    }
}
