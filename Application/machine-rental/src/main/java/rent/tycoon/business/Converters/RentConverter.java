package rent.tycoon.business.Converters;

import rent.tycoon.domain.Rent;
import rent.tycoon.domain.dto.CreateRent;

public class RentConverter {
    public static Rent toRent(CreateRent createRent) {
        Rent rent = Rent.builder()
                .productId(createRent.getProductId())
                .customerId(createRent.getCustomerId())
                .start(createRent.getStart())
                .total(createRent.getTotal())
                .end(createRent.getEnd())
                .paid(createRent.getPaid())
                .discount(createRent.getDiscount())
                .address(createRent.getAddress())
                .city(createRent.getCity())
                .timestamp(createRent.getTimestamp())
                .build();
        return rent;
    }
}
