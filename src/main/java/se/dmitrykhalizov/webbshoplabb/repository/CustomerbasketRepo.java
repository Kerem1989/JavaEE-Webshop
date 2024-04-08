package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.entity.User;

import java.util.List;

public interface CustomerbasketRepo extends JpaRepository<Customerbasket, Integer> {
    public List<Customerbasket> findByUser(User user);

    public Customerbasket findByUserAndProduct(User user, Product product);

    @Modifying
    @Query("delete from Customerbasket c where c.user.userid = ?1 and c.product.productid = ?2")
    public void deleteByUserAndProduct(int customerid, int productid);

    @Modifying
    @Query("update Customerbasket c set c.quantity = ?1 where c.user.userid = ?2 and c.product.productid = ?3")
    public void updateQuantity(int quantity, int userid, int productid);
}
