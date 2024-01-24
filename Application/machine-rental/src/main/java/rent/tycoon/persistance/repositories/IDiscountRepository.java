package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.tycoon.persistance.databases.entity.DiscountJpaMapper;

public interface IDiscountRepository extends JpaRepository<DiscountJpaMapper, Integer> {
    DiscountJpaMapper findByCode(String code);
}
