package se.kerem.webshop.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kerem.webshop.entity.Product;
import se.kerem.webshop.repository.ProductRepo;

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

    public List<Product> findProductByCategory(String category) {
        return productRepo.findProductByCategory(category);
    }

    public List<Product> findByKeyword(String keyword) {
        return productRepo.findByKeyword(keyword);
    }

    public Product newProduct() {
        Product product = new Product();
        product.setInStock(true);
        return product;
    }
}
