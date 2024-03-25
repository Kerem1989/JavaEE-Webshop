package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.entity.Orderline;

public interface OrderlineRepo extends JpaRepository <Orderline, Integer> {
}
