package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;

import java.util.Optional;

@Repository
public interface IRentRepository extends JpaRepository<RentJpaMapper, String> {
    Optional <RentJpaMapper> findById(long rentId);
}
