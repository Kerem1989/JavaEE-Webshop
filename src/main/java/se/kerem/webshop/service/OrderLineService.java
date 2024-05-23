package se.kerem.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kerem.webshop.entity.Order;
import se.kerem.webshop.entity.Orderline;
import se.kerem.webshop.repository.OrderlineRepo;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    OrderlineRepo orderlineRepo;

    public List<Orderline> listOrderline(Order order) {
        return orderlineRepo.findOrderlineByOrder(order.getOrderid());
    }
}
