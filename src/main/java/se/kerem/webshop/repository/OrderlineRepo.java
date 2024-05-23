package se.kerem.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.kerem.webshop.entity.Orderline;

import java.util.List;

@Repository
public interface OrderlineRepo extends JpaRepository <Orderline, Integer> {
    @Query("SELECT ol FROM Orderline ol WHERE ol.order.orderid = :order")
    List<Orderline> findOrderlineByOrder(@org.springframework.data.repository.query.Param("order") int order);

}
