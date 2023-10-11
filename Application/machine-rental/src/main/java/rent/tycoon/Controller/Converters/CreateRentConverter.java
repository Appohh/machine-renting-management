package rent.tycoon.Controller.Converters;

import org.springframework.stereotype.Component;
import rent.tycoon.business.dto.CreateRentRequest;
import rent.tycoon.business.dto.CreateRentResponse;

@Component
public class CreateRentConverter {

    public static CreateRentRequest toCreateRentRequest(CreateRentRequest request){
        return CreateRentRequest.builder()
                .productId(request.getProductId())
                .customerId(request.getCustomerId())
                .start(request.getStart())
                .end(request.getEnd())
                .paid(request.getPaid())
                .discount(request.getDiscount())
                .address(request.getAddress())
                .city(request.getCity())
                .timestamp(request.getTimestamp())
                .total(request.getTotal())
                .build();
    }

    public static CreateRentResponse responseConverter(CreateRentRequest createRent){
        return CreateRentResponse.builder()
                .build();
    }

}
