package se.dmitrykhalizov.webbshoplabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import se.dmitrykhalizov.webbshoplabb.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
