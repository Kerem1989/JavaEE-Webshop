package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.database.Orderline;

public interface OrderlineRepo extends JpaRepository <Orderline, Integer> {
}
