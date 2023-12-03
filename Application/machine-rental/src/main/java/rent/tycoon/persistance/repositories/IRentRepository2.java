package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;

@Repository
public interface IRentRepository2  extends JpaRepository<RentJPAmapper2, String> {
}
