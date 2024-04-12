package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    boolean existsUserByUsernameAndPassword(String username, String password);
    boolean existsUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByUserid(int id);

}
