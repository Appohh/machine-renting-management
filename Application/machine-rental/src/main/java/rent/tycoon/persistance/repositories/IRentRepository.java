package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRentRepository extends JpaRepository<RentJpaMapper, String> {
    Optional <RentJpaMapper> findById(long rentId);
    List<RentJpaMapper> findByCustomerId(long customerId);
}
