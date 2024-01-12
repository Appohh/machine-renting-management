package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.domain.RentRow;
import rent.tycoon.persistance.converter.IRentConverter;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;
import rent.tycoon.persistance.repositories.IRentRepository;
import rent.tycoon.persistance.repositories.IRentRowRepository;

import java.util.Optional;


@Repository
public class RentMySqlGateway implements IRentRepo {
    private final IRentRepository repository;
    private final IRentRowRepository rentRowRepository;
    private final IRentConverter converter;

    @Autowired
    public RentMySqlGateway(IRentRepository repository, IRentRowRepository rentRowRepository, IRentConverter converter) {
        this.repository = repository;
        this.rentRowRepository = rentRowRepository;
        this.converter = converter;
    }

    @Transactional
    public long save(Rent rent){
        RentJpaMapper rentJpaMapper = converter.toRentJpaEntity(rent);
        return repository.save(rentJpaMapper).getId();
    }

    @Transactional
    public long saveRentRow(RentRow rentRow){
        RentRowJpaMapper rentRowJpaMapper = converter.toRentRowJpaEntity(rentRow);
        return rentRowRepository.save(rentRowJpaMapper).getId();
    }

    public Optional<Rent> findByRentId(long rentId){
        Optional<RentJpaMapper> optionalPostJpaMapper = repository.findById(rentId);
        return converter.toSingleOptionalRent(optionalPostJpaMapper);
    }
}
