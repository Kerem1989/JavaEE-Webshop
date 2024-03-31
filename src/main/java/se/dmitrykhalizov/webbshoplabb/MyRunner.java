package se.dmitrykhalizov.webbshoplabb;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.EnumSelection;
import se.dmitrykhalizov.webbshoplabb.entity.Order;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.service.CustomerbasketService;
import se.dmitrykhalizov.webbshoplabb.service.ProductService;
import se.dmitrykhalizov.webbshoplabb.service.UserService;

import java.time.LocalDate;


@Component
public class MyRunner implements CommandLineRunner {

    private final UserService userService;
    private final CustomerbasketService customerbasketService;
    private final ProductService productService;

    public MyRunner(UserService userService, CustomerbasketService customerbasketService, ProductService productService) {
        this.userService = userService;
        this.customerbasketService = customerbasketService;
        this.productService = productService;
    }

    @Override
    public void run(String[] args) {

    }

}
