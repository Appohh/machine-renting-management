package rent.tycoon.persistance.gateways.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.persistance.gateways.mapper.RentJpaMapper;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.domain.Rent;


@Repository
public class RentMySqlRepo implements IRentRepo {
    private final rent.tycoon.persistance.repositories.IRentRepository repository;

    @Autowired
    public RentMySqlRepo(rent.tycoon.persistance.repositories.IRentRepository repository) {this.repository = repository;}

    public long save(Rent rent){
        RentJpaMapper rentJpaMapper = RentJpaMapper.builder()
                .productId(rent.getProductId())
                .customerId(rent.getCustomerId())
                .start(rent.getStart())
                .end(rent.getEnd())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .total(rent.getTotal())
                .discount(rent.getDiscount())
                .paid(rent.getPaid())
                .build();
        return repository.save(rentJpaMapper).getId();
    }

    @Override
    public boolean existsByProductId(long productId){
        return repository.existsByProductId(productId);
    }
}
