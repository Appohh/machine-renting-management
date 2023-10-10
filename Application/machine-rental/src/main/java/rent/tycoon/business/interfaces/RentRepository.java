package rent.tycoon.business.interfaces;

import rent.tycoon.domain.Rent;
import rent.tycoon.domain.dto.CreateRent;

public interface RentRepository {

    Rent saveRent(Rent createRent);

}
