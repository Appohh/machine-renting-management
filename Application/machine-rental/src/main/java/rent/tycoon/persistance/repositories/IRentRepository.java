package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.gateways.mapper.RentJpaMapper;

@Repository
public interface IRentRepository extends JpaRepository<RentJpaMapper, String> {
    boolean existsByProductId (long productId);
}
