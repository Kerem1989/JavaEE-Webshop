package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.entity.Orderline;
import se.dmitrykhalizov.webbshoplabb.entity.User;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query("SELECT DISTINCT o FROM Order o JOIN FETCH o.orderlines ol WHERE o.user = :user")
    List<Order> findOrdersByUserAndOrderline(@Param("user") User user);
}

