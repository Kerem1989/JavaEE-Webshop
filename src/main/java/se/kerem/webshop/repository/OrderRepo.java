package se.kerem.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.kerem.webshop.entity.Order;
import se.kerem.webshop.entity.Orderline;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.user.userid = :user")
    List<Order> findOrderByUserid(@Param("user") int user);

    @Query("SELECT ol FROM Orderline ol WHERE ol.order = :order")
    List<Orderline> findOrderlinesByOrder(@Param("order") Order order);


}

