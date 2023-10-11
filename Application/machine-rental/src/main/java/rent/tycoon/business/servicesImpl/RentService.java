package rent.tycoon.business.servicesImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.Converters.RentConverter;
import rent.tycoon.business.dto.CreateRentRequest;
import rent.tycoon.business.dto.CreateRentResponse;
import rent.tycoon.business.interfaces.RentRepository;
import rent.tycoon.business.interfaces.RentServiceInterface;
import rent.tycoon.domain.Rent;

@Service
@AllArgsConstructor
public class RentService implements RentServiceInterface {

    private final RentRepository rentRepository;
    public CreateRentResponse createRent(CreateRentRequest request){
        Rent rent = RentConverter.toRent(request);
        rentRepository.saveRent(rent);
        return RentConverter.toResponse(rent);
    }


    @Override
    public boolean BoolIsAvailable(long id){
        return false;
    }
}
