package rent.tycoon.business.servicesImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.Converters.RentConverter;
import rent.tycoon.business.interfaces.RentRepository;
import rent.tycoon.business.interfaces.RentServiceInterface;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.dto.CreateRentDTO;

@Service
@AllArgsConstructor
public class RentService implements RentServiceInterface {

    private final RentRepository rentRepository;
    public Rent createRent(CreateRentDTO createRentDTO){

            Rent rent = RentConverter.toRent(createRentDTO);
            rentRepository.saveRent(rent);
            return rent;
    }


    @Override
    public boolean BoolIsAvailable(long id){
        return false;
    }
}
