package se.dmitrykhalizov.webbshoplabb.ui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.CustomerbasketService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerbasketRestControllerTest {
    @Autowired
    CustomerbasketService customerbasketService;

    @Autowired
    UserService userService;

    @Test
    void addProductToBasket() {
        User user = userService.getUser(1);
        int updatedQuantity = customerbasketService.addProduct(13, 1, user);
        assertEquals(1, updatedQuantity);
    }

    @Test
    public void testGetTotalPrice() {
        User user = new User();
        Product product = new Product();
        product.setPrice(100);
        Customerbasket customerbasket = new Customerbasket(user, product, 2);

        double expectedTotalPrice = 200;
        double actualTotalPrice = customerbasket.getTotalPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice, "The total price should be correct");
    }

    @Test
    public void testSetQuantity() {
        User user = new User();
        Product product = new Product();
        Customerbasket customerbasket = new Customerbasket(user, product, 2);

        customerbasket.setQuantity(3);
        int expectedQuantity = 3;
        int actualQuantity = customerbasket.getQuantity();

        assertEquals(expectedQuantity, actualQuantity, "The quantity should be correct");
    }
}