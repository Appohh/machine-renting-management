package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.converter.RentConverter;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;
import rent.tycoon.persistance.repositories.IRentRepository;
import rent.tycoon.persistance.repositories.IRentRowRepository;


@Repository
public class RentMySqlGateway implements IRentRepo {
    private final IRentRepository repository;
    private final IRentRowRepository rentRowRepository;

    @Autowired
    public RentMySqlGateway(IRentRepository repository, IRentRowRepository rentRowRepository) {this.repository = repository; this.rentRowRepository=rentRowRepository;}

    public long save(Rent rent){
        RentJpaMapper rentJpaMapper = RentConverter.convertToRentJpaMapper(rent);
        RentRowJpaMapper rentRowJpaMapper = RentConverter.convertToRentRowJpaMapper(rent);
        rentRowRepository.save(rentRowJpaMapper);
        return repository.save(rentJpaMapper).getId();

    }
}
