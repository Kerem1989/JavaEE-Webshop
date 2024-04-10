package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.repository.CustomerbasketRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerbasketService {

    @Autowired
    private CustomerbasketRepo customerbasketRepo;

    @Autowired
    private ProductService productService;

        public Integer addProduct(Integer productId, Integer quantity, User user) {
            Integer updatedQuantity = quantity;

            // Retrieve the product from the database using the productId
            Product product = productService.getProductById(productId);

            Customerbasket customerbasket = customerbasketRepo.findByUserAndProduct(user, product);

            if (customerbasket!= null) {
                updatedQuantity = customerbasket.getQuantity() + quantity;
            } else {
                customerbasket = new Customerbasket();
                customerbasket.setUser(user);
                customerbasket.setProduct(product);
            }

            customerbasket.setQuantity(updatedQuantity);

            customerbasketRepo.save(customerbasket);

            return updatedQuantity;
        }

        public List<Customerbasket> listCustomerbasket(User user) {
            return customerbasketRepo.findByUser(user);
        }
    }