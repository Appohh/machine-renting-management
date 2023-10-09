package rent.tycoon.business.servicesImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.RentRepository;
import rent.tycoon.business.interfaces.RentServiceInterface;
import rent.tycoon.domain.CreateRent;

@Service
@AllArgsConstructor
public class RentService implements RentServiceInterface {

    private final RentRepository rentRepository;
    public CreateRent createRent(CreateRent createRent){
            CreateRent newRent = saveRent(createRent);
            return newRent; //WEET NOG NIET WAT HIER MOET
    }

    public CreateRent saveRent(CreateRent createRent){

        CreateRent newRent = CreateRent.builder()
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
        return rentRepository.saveRent(newRent);
    }


    @Override
    public boolean BoolIsAvailable(long id){
        return false;
    }
}
