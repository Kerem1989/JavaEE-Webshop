package se.kerem.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kerem.webshop.entity.*;
import se.kerem.webshop.repository.OrderRepo;
import se.kerem.webshop.repository.OrderlineRepo;
import se.kerem.webshop.entity.Customerbasket;
import se.kerem.webshop.entity.Order;
import se.kerem.webshop.entity.Orderline;
import se.kerem.webshop.entity.User;

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
        order.setStatus(false);
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
        String body = "Your order has been placed. Order ID: " + order.getOrderid() + "Details: " + customerbasketList;
        emailSenderService.sendEmail(toEmail, subject, body);

        return order;
    }

    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    public void changeStatus(int orderId, Boolean status) {
            Order order = orderRepo.findById(orderId).get();
            order.setStatus(status);
            orderRepo.save(order);

            String toEmail = order.getUser().getEmail();
            String subject = "Order status update";
            String body = "Your order with ID: " + order.getOrderid() + " is now sent";
            emailSenderService.sendEmail(toEmail, subject, body);
    }


    public List<Order> findOrderByUserid(int userid) {
        return orderRepo.findOrderByUserid(userid);
    }

    public List<Orderline> findOrderlinesByOrder(Order order) {
        return orderRepo.findOrderlinesByOrder(order);
    }

}