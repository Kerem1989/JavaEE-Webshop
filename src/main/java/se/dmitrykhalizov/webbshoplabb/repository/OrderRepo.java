package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.entity.Order;

public interface OrderRepo extends JpaRepository <Order, Integer> {
}
