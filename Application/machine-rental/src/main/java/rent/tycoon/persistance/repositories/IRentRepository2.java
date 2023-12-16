package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rent.tycoon.domain.Rent2;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;

import java.util.List;

@Repository
public interface IRentRepository2  extends JpaRepository<RentJPAmapper2, String> {
    List<RentJPAmapper2> findRentByCustomerId(long customerId);

    @Query("SELECT p FROM ProductJpaMapper p JOIN RentJPAmapper2 r ON p.id = r.productId WHERE r.id = :rentId")
    ProductJpaMapper findProductByRentId(long rentId);
}
