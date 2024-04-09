package se.dmitrykhalizov.webbshoplabb.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import se.dmitrykhalizov.webbshoplabb.repository.CategoryRepo;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class CategoryTest {

    @Autowired
    private CategoryRepo repo;

    @Test
    public void testListEnabledCategories() {
        List<Category> listCategories = repo.findAllEnabled();
        listCategories.forEach(category -> System.out.println(category.getName() + " (" + category.isEnabled() + ")"));
    }

}