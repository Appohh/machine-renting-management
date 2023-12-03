package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Rent;
import rent.tycoon.domain.Rent2;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.List;

public class RentConverter2 {

    public static RentJPAmapper2 toRentJpaEntity(Rent2 rent) {

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
}
