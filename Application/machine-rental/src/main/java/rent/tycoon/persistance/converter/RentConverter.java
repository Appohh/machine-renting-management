package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

public class RentConverter {

    public static RentJpaMapper convertToRentJpaMapper(Rent rent) {
        return RentJpaMapper.builder()
                .customerId(rent.getCustomerId())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .total(rent.getTotal())
                .discount(rent.getDiscount())
                .paid(rent.getPaid())
                .build();
    }

    public static RentRowJpaMapper convertToRentRowJpaMapper(Rent rent) {
        return RentRowJpaMapper.builder()
                .rent_id(rent.getId())
                .product_id(rent.getProduct_id())
                .startDate(rent.getStartDate())
                .endDate(rent.getEndDate())
                .timestamp(rent.getTimestamp())
                .build();
    }
}
