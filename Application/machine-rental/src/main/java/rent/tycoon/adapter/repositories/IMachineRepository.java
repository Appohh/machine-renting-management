package rent.tycoon.adapter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.gateways.mapper.MachineJpaMapper;

@Repository
public interface IMachineRepository extends JpaRepository<MachineJpaMapper, String> {
    boolean existsByName(String name);
}
