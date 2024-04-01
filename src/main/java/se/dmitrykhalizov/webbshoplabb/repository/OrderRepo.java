package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.entity.Order;

import java.util.List;

public interface OrderRepo extends JpaRepository <Order, Integer> {
    List<Order> findOrdersByUser(int userId);
}
