package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.databases.entity.CategoryJpaMapper;

import java.util.List;
import java.util.Set;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryJpaMapper, Integer> {
}
