package rent.tycoon.business.Converters;

import rent.tycoon.business.dto.CreateRentRequest;
import rent.tycoon.business.dto.CreateRentResponse;
import rent.tycoon.domain.Rent;

public class RentConverter {
    public static Rent toRent(CreateRentRequest request) {
        return Rent.builder()
                .productId(request.getProductId())
                .customerId(request.getCustomerId())
                .start(request.getStart())
                .total(request.getTotal())
                .end(request.getEnd())
                .paid(request.getPaid())
                .discount(request.getDiscount())
                .address(request.getAddress())
                .city(request.getCity())
                .timestamp(request.getTimestamp())
                .build();
    }



    public static CreateRentResponse toResponse(Rent rent){
        return CreateRentResponse.builder()
                .id(rent.getId())
                .build();
    }
}
