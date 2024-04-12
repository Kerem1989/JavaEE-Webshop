package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.dmitrykhalizov.webbshoplabb.entity.Orderline;

import java.util.List;

@Repository
public interface OrderlineRepo extends JpaRepository <Orderline, Integer> {

}
