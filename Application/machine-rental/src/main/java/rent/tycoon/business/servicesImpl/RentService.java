package rent.tycoon.business.servicesImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.Converters.RentConverter;
import rent.tycoon.business.interfaces.RentRepository;
import rent.tycoon.business.interfaces.RentServiceInterface;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.dto.CreateRent;

@Service
@AllArgsConstructor
public class RentService implements RentServiceInterface {

    private final RentRepository rentRepository;
    public CreateRent createRent(CreateRent createRent){
            Rent rent = RentConverter.toRent(createRent);
            rentRepository.saveRent(rent);
            return createRent;
    }


    @Override
    public boolean BoolIsAvailable(long id){
        return false;
    }
}
