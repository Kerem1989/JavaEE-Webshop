package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.EnumSelection;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import java.util.List;


@Service
public class ProductService {
    ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public String createProduct(String name, String description, double price,
                                int quantity, EnumSelection status) {

        productRepo.save(new Product(name, description, price, quantity, status));
        return "Saved";
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



}
