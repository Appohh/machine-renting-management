package rent.tycoon.business.servicesImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.RentServiceInterface;
@Service
@AllArgsConstructor
public class RentService implements RentServiceInterface {

    /*
    public CreateRent(CreateRent createRent){
        //Idk wat hier de bedoeling is
    }
     */

    @Override
    public boolean BoolIsAvailable(long id){
        return false;
    }
}
