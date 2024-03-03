package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.dmitrykhalizov.webbshoplabb.database.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}
