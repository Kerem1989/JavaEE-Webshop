package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.database.Product;

public interface ProductRepo extends JpaRepository <Product, Integer> {
}
