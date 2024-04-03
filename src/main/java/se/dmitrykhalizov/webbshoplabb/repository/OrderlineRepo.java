package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.entity.Orderline;

import java.util.List;

public interface OrderlineRepo extends JpaRepository <Orderline, Integer> {

}
