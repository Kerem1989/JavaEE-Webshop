package se.dmitrykhalizov.webbshoplabb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.entity.EnumSelection;
import se.dmitrykhalizov.webbshoplabb.entity.Product;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;
import se.dmitrykhalizov.webbshoplabb.ui.IO;

import java.util.List;


@Service
public class ProductService {
    ProductRepo productRepo;
    IO io;

    @Autowired
    public ProductService(ProductRepo productRepo, IO io) {
        this.productRepo = productRepo;
        this.io = io;
    }

    public String create(String name, String description, double price,
                         int quantity, EnumSelection status) {
        productRepo.save(new Product(name, description, price, quantity, status));
        return "Saved";
    }

    public List<Product> displayProducts() {
        return productRepo.findAll();
    }


}
