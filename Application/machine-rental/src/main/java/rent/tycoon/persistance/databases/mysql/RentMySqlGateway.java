package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.repositories.IRentRepository;


@Repository
public class RentMySqlGateway implements IRentRepo {
    private final IRentRepository repository;

    @Autowired
    public RentMySqlGateway(IRentRepository repository) {this.repository = repository;}

    public long save(Rent rent){
        RentJpaMapper rentJpaMapper = RentJpaMapper.builder()
                .customerId(rent.getCustomerId())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .total(rent.getTotal())
                .discount(rent.getDiscount())
                .paid(rent.getPaid())
                .build();
        return repository.save(rentJpaMapper).getId();
    }
}
