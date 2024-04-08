package se.dmitrykhalizov.webbshoplabb.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.Category;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import java.util.List;


@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryService categoryService;

    public List<Product> listAll() {
        return productRepo.findAll();
    }

    public List<Product> displayProducts() {
        return productRepo.findAll();
    }

    public Product getProductByName(String name) {
        return productRepo.findProductByName(name);
    }

    public Product getProductById(int id) {
        return productRepo.findProductByProductid(id);
    }

    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    public void updateInStockStatus(int productid, boolean instock) {
        productRepo.updateInStockStatus(productid, instock);
    }

    public void deleteProduct(int id) {
        int countById = productRepo.countByProductid(id);
        if (countById == 0) {
            throw new RuntimeException("Could not find any product with ID " + id);
        } else {
            productRepo.deleteById(id);
        }
    }
}
