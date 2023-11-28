package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.tycoon.persistance.databases.entity.CategoryJpaMapper;

public interface ICategoryRepository extends JpaRepository<CategoryJpaMapper, Integer> {
}
