package rent.tycoon.adapter.gateways.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.gateways.mapper.RentJpaMapper;
import rent.tycoon.adapter.repositories.IRentRepository;
import rent.tycoon.business.boundaries.output.IRentGateway;
import rent.tycoon.domain.Rent;


@Repository
public class RentMySqlGateway implements IRentGateway {
    private final IRentRepository repository;

    @Autowired
    public RentMySqlGateway(IRentRepository repository) {this.repository = repository;}

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
