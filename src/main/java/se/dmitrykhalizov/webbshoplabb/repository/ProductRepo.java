package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import se.dmitrykhalizov.webbshoplabb.entity.Product;

public interface ProductRepo extends JpaRepository <Product, Integer> {
    Product findProductByName(String name);

    Product findProductByProductid(int id);

    @Modifying
    @Query("update Product p set p.InStock = ?2 where p.productid = ?1")
    public void updateInStockStatus(int productid, boolean instock);

    public int countByProductid(int id);
}
