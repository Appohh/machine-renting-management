package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;

import java.util.List;

@Repository
public interface IRentRepository2  extends JpaRepository<RentJPAmapper2, String> {
    @Query("SELECT r, p FROM RentJPAmapper2 r JOIN ProductJpaMapper p ON r.productId = p.id WHERE r.customerId = :customerId")
    List<Object[]> findRentAndProductByCustomerId(long customerId);
}
