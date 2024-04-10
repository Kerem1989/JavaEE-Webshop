package se.dmitrykhalizov.webbshoplabb.ui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}