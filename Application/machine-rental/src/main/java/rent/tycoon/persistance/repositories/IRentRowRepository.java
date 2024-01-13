package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.List;

@Repository
public interface IRentRowRepository extends JpaRepository<RentRowJpaMapper, String> {
    List<RentRowJpaMapper> findAllByRentId(long rentId);
}
