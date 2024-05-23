package se.kerem.webshop.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testSetAndGetProductid() {
        int productId = 1;
        product.setProductid(productId);
        assertEquals(productId, product.getProductid());
    }

    @Test
    public void testSetAndGetName() {
        String name = "Test Product";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    public void testSetAndGetDescription() {
        String description = "This is a test product";
        product.setDescription(description);
        assertEquals(description, product.getDescription());
    }

    @Test
    public void testSetAndGetPrice() {
        double price = 19.99;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    public void testSetAndGetInStock() {
        boolean inStock = true;
        product.setInStock(inStock);
        assertEquals(inStock, product.isInStock());
    }
}