package se.dmitrykhalizov.webbshoplabb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dmitrykhalizov.webbshoplabb.database.Product;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List <Product> displayProducts(){
        return productRepo.findAll();
    }
}
