package se.dmitrykhalizov.webbshoplabb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import se.dmitrykhalizov.webbshoplabb.entity.User;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderlineRepo orderlineRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddNewOrder() {
        User user = entityManager.find(User.class, 1);
    }

}