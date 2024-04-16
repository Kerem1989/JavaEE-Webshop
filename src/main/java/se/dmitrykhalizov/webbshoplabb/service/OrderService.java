package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.*;
import se.dmitrykhalizov.webbshoplabb.repository.OrderRepo;
import se.dmitrykhalizov.webbshoplabb.repository.OrderlineRepo;

import java.time.LocalDate;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderlineRepo orderlineRepo;
    @Autowired
    private EmailSenderService emailSenderService;

    public Order createOrder(User user, List<Customerbasket> customerbasketList) {
        Order order = new Order();
        order.setUser(user);
        order.setDate(LocalDate.now());
        order.setStatus(EnumSelection.pending);
        orderRepo.save(order);
        double total = 0;
        for (Customerbasket customerbasket : customerbasketList) {
            Orderline orderline = new Orderline();
            orderline.setOrder(order);
            orderline.setProduct(customerbasket.getProduct());
            orderline.setQuantity(customerbasket.getQuantity());
            orderline.setUnitPrice(customerbasket.getProduct().getPrice());
            double subTotal = customerbasket.getQuantity() * customerbasket.getProduct().getPrice();
            orderline.setSubTotal(subTotal);
            orderlineRepo.save(orderline);
            total += subTotal;
        }
        order.setTotal(total);
        orderRepo.save(order);

        String toEmail = user.getEmail();
        String subject = "Order confirmation";
        String body = "Your order has been placed. Order ID: " + order.getOrderid();
        emailSenderService.sendEmail(toEmail, subject, body);

        return order;
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

}