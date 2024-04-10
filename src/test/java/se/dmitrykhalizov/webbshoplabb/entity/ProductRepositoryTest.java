package se.dmitrykhalizov.webbshoplabb.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import se.dmitrykhalizov.webbshoplabb.repository.ProductRepo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateProduct() {
        Category category = testEntityManager.find(Category.class, 2);
        Product product = new Product();
        product.setName("Acer 55");
        product.setDescription("Acer Home Laptop");
        product.setPrice(1200);
        product.setCategory(category);
        product.setInStock(true);
        Product savedProduct = productRepo.save(product);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getProductid()).isGreaterThan(0);

    }

    @Test
    public void testListProducts() {
        Iterable<Product> products = productRepo.findAll();
        products.forEach(System.out::println);
    }

    @Test
    public void testGetProduct() {
        Integer id = 9;
        Product product = productRepo.findById(id).get();
        System.out.println(product);
        assertThat(product).isNotNull();
    }

    @Test
    public void testUpdateProduct() {
        Integer id = 9;
        Product product = productRepo.findProductByProductid(id);
        product.setPrice(1500);
        productRepo.save(product);
        Product updatedProduct = testEntityManager.find(Product.class, id);
        assertThat(updatedProduct.getPrice()).isEqualTo(1500);
    }

    @Test
    public void testDeleteProduct() {
        Integer id = 9;
        productRepo.deleteById(id);
        Product product = testEntityManager.find(Product.class, id);
        assertThat(product).isNull();
    }

    @Test
    public void testFindByName () {
        String name = "Canon 55A";
        Product product = productRepo.findProductByName(name);
        assertThat(product).isNotNull();
    }


}
