package rent.tycoon.persistance.converter;

import org.springframework.stereotype.Service;
import rent.tycoon.domain.Rent2;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;

@Service
public class RentConverter2 implements IRentConverter{

    @Override
    public RentJPAmapper2 toRentJpaEntity(Rent2 rent) {
        return RentJPAmapper2.builder()
                .id(rent.getId())
                .customerId(rent.getCustomerId())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .total(rent.getTotal())
                .discount(rent.getDiscount())
                .paid(rent.getPaid())
                .productId(rent.getProductId())
                .startDate(rent.getStartDate())
                .endDate(rent.getEndDate())
                .build();
    }

    @Override
    public Rent2 toRent(RentJPAmapper2 rentJPAmapper2){
        return Rent2.builder()
                .id(rentJPAmapper2.getId())
                .customerId(rentJPAmapper2.getCustomerId())
                .address(rentJPAmapper2.getAddress())
                .city(rentJPAmapper2.getCity())
                .timestamp(rentJPAmapper2.getTimestamp())
                .total(rentJPAmapper2.getTotal())
                .discount(rentJPAmapper2.getDiscount())
                .paid(rentJPAmapper2.getPaid())
                .productId(rentJPAmapper2.getProductId())
                .startDate(rentJPAmapper2.getStartDate())
                .endDate(rentJPAmapper2.getEndDate())
                .build();

    }
}
