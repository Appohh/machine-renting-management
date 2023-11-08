package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.persistance.converter.RentConverter;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.repositories.IRentRepository;


@Repository
public class RentMySqlGateway implements IRentRepo {
    private final IRentRepository repository;

    @Autowired
    public RentMySqlGateway(IRentRepository repository) {this.repository = repository;}

    @Transactional
    public long save(Rent rent){
        RentJpaMapper rentJpaMapper = RentConverter.toRentJpaEntity(rent);
        rentJpaMapper.getRentRow().forEach(rentRow -> rentRow.setRent(rentJpaMapper));
        return repository.save(rentJpaMapper).getId();
    }
}
