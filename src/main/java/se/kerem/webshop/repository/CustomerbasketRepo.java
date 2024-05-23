package se.kerem.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import se.kerem.webshop.entity.Customerbasket;
import se.kerem.webshop.entity.Product;
import se.kerem.webshop.entity.User;

import java.util.List;

public interface CustomerbasketRepo extends JpaRepository<Customerbasket, Integer> {
    List<Customerbasket> findByUser(User user);

    Customerbasket findByUserAndProduct(User user, Product product);

    @Modifying
    @Query("delete from Customerbasket c where c.user.userid = ?1 and c.product.productid = ?2")
    void deleteByUserAndProduct(int customerid, int productid);

    @Modifying
    @Query("update Customerbasket c set c.quantity = ?1 where c.user.userid = ?2 and c.product.productid = ?3")
    void updateQuantity(int quantity, int userid, int productid);

    void deleteCustomerbasketByUser (User user);


}
