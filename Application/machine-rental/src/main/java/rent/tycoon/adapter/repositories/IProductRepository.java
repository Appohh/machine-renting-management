package rent.tycoon.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductJpaMapper, String> {
    boolean existsByName(String name);
    List<ProductJpaMapper> findProductByName(String name);
}
