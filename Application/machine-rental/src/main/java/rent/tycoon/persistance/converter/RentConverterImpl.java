package rent.tycoon.persistance.converter;

import org.springframework.stereotype.Service;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.RentRow;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.Optional;

@Service
public class RentConverterImpl implements IRentConverter{

    @Override
    public RentJpaMapper toRentJpaEntity(Rent rent) {
        return RentJpaMapper.builder()
                .id(rent.getId())
                .customerId(rent.getCustomerId())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .total(rent.getTotal())
                .discount(rent.getDiscount())
                .paid(rent.getPaid())
                .build();
    }

    public RentRowJpaMapper toRentRowJpaEntity(RentRow rentRow){
        return RentRowJpaMapper.builder()
                .id(rentRow.getId())
                .productId(rentRow.getProductId())
                .startDate(rentRow.getStartDate())
                .endDate(rentRow.getEndDate())
                .rentId(rentRow.getRentId())
                .quantity(rentRow.getQuantity())
                .build();
    }


    @Override
    public Optional<Rent> toSingleOptionalRent(Optional<RentJpaMapper> rentJpaOptional){
        return rentJpaOptional.map(jpaMapper -> Rent.builder()
                .id(jpaMapper.getId())
                .customerId(jpaMapper.getCustomerId())
                .address(jpaMapper.getAddress())
                .city(jpaMapper.getCity())
                .timestamp(jpaMapper.getTimestamp())
                .total(jpaMapper.getTotal())
                .discount(jpaMapper.getDiscount())
                .paid(jpaMapper.getPaid())
                .build());
    }
}
