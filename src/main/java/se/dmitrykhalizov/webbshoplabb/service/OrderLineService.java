package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.entity.Orderline;
import se.dmitrykhalizov.webbshoplabb.repository.OrderlineRepo;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    OrderlineRepo orderlineRepo;

    public List<Orderline> listOrderline(Order order) {
        return orderlineRepo.findOrderlineByOrder(order.getOrderid());
    }
}
