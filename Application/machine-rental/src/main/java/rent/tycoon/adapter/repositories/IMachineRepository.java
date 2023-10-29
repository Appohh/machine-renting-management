package rent.tycoon.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;

@Repository
public interface IMachineRepository extends JpaRepository<ProductJpaMapper, String> {
    boolean existsByName(String name);
}
