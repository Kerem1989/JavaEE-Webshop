package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.database.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsUserByUsernameAndPassword(String username, String password);
    User findUserByUsernameAndPassword(String username, String password);
    boolean existsUserByUserid(int id);
}
