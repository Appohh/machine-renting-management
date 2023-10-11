package rent.tycoon.business.Converters;

import rent.tycoon.business.dto.CreateRentRequest;
import rent.tycoon.business.dto.CreateRentResponse;
import rent.tycoon.domain.Rent;

public class RentConverter {
    public static Rent toRent(CreateRentRequest createRent) {
        return Rent.builder()
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
    }

    public static CreateRentResponse toResponse(Rent rent){
        return CreateRentResponse.builder()
                .id(rent.getId())
                .build();
    }
}
