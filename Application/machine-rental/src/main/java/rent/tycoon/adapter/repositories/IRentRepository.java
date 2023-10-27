package rent.tycoon.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.gateways.mapper.RentJpaMapper;

@Repository
public interface IRentRepository extends JpaRepository<RentJpaMapper, String> {
}
