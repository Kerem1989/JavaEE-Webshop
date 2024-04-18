package se.dmitrykhalizov.webbshoplabb.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.Customerbasket;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.entity.User;
import se.dmitrykhalizov.webbshoplabb.repository.CustomerbasketRepo;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import java.util.List;

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

    public double estimateTotalPrice(List<Customerbasket> customerbasketList){
        double estimatedTotal = 0;
        for (Customerbasket customerbasket : customerbasketList) {
            estimatedTotal += customerbasket.getTotalPrice();
        }
        return estimatedTotal;
    }
  
    public void deleteActiveCustomerbasket(User user){
        customerbasketRepo.deleteCustomerbasketByUser(user);
    }
}