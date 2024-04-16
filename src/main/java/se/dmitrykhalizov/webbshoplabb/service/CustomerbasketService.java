package se.dmitrykhalizov.webbshoplabb.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.repository.CustomerbasketRepo;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerbasketService {

    @Autowired
    private CustomerbasketRepo customerbasketRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepo productRepo;

    public Integer addProduct(Integer productId, Integer quantity, User user) {
        Integer updatedQuantity = quantity;
        Product product = productService.getProductById(productId);
        Customerbasket customerbasket = customerbasketRepo.findByUserAndProduct(user, product);
        if (customerbasket != null) {
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

    public double updateQuantity(int productId, int quantityToUpdate, int userId) {
        customerbasketRepo.updateQuantity(quantityToUpdate, userId, productId);
        Product product = productRepo.findById(productId).orElse(null);
        if (product != null) {
            double subtotal = product.getPrice() * quantityToUpdate;
            return subtotal;
        }
        return 0;
    }

    public void deleteProduct(int productId, int userId) {
        customerbasketRepo.deleteByUserAndProduct(userId, productId);
    }

    public void clearBasket(User user) {
        List<Customerbasket> customerbasketList = customerbasketRepo.findByUser(user);
        for (Customerbasket customerbasket : customerbasketList) {
            customerbasketRepo.delete(customerbasket);
        }
    }

}