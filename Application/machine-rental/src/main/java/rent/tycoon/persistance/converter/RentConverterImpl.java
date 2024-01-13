package rent.tycoon.persistance.converter;

import org.springframework.stereotype.Service;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.RentRow;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @Override
    public List<Rent> toListOfRents(List<RentJpaMapper> rentJpaMappers){
        return rentJpaMappers.stream()
                .map(mapper -> new Rent(
                        mapper.getId(),
                        mapper.getCustomerId(),
                        mapper.getAddress(),
                        mapper.getCity(),
                        mapper.getTimestamp(),
                        mapper.getTotal(),
                        mapper.getDiscount(),
                        mapper.getPaid()))
                .toList();
    }

    @Override
    public List<RentRow> toListOfRentRows(List<RentRowJpaMapper> rentRowJpaMappers){
        return rentRowJpaMappers.stream()
                .map(mapper -> new RentRow(
                        mapper.getId(),
                        mapper.getProductId(),
                        mapper.getStartDate(),
                        mapper.getEndDate(),
                        mapper.getRentId()))
                .toList();
    }
}
