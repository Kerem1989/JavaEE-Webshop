package se.dmitrykhalizov.webbshoplabb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.dmitrykhalizov.webbshoplabb.repository.*;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    OrderlineRepo orderlineRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CustomerbasketRepo customerbasketRepo;

    @Override
    public void run(String[] args) throws Exception {
        System.out.println("HALLO");
        System.out.println("HALLO AGAIN");
    }
}
