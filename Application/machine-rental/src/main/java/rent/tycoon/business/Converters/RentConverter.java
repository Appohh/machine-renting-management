package rent.tycoon.business.Converters;

import rent.tycoon.domain.Rent;
import rent.tycoon.domain.dto.CreateRentDTO;

public class RentConverter {
    public static Rent toRent(CreateRentDTO createRentDTO) {
        Rent rent = Rent.builder()
                .productId(createRentDTO.getProductId())
                .customerId(createRentDTO.getCustomerId())
                .start(createRentDTO.getStart())
                .total(createRentDTO.getTotal())
                .end(createRentDTO.getEnd())
                .paid(createRentDTO.getPaid())
                .discount(createRentDTO.getDiscount())
                .address(createRentDTO.getAddress())
                .city(createRentDTO.getCity())
                .timestamp(createRentDTO.getTimestamp())
                .build();
        return rent;
    }
    public static CreateRentDTO toCreateRent(Rent rent) {
        CreateRentDTO createRentDTO = CreateRentDTO.builder()
                 .productId(rent.getProductId())
                .customerId(rent.getCustomerId())
                .start(rent.getStart())
                .total(rent.getTotal())
                .end(rent.getEnd())
                .paid(rent.getPaid())
                .discount(rent.getDiscount())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .build();
        return createRentDTO;
    }
}
