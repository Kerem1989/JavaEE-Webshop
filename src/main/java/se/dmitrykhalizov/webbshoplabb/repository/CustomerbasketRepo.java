package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.database.Customerbasket;

public interface CustomerbasketRepo extends JpaRepository <Customerbasket, Integer> {
}
