package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public String createProduct(String name, String description, double price, boolean InStock, boolean dispatched) {
        Product product = new Product(name, description, price, InStock, dispatched);
        productRepo.save(product);
        return "Product created";
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
