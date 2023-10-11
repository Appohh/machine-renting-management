package rent.tycoon.business.interfaces;

import rent.tycoon.business.dto.CreateRentRequest;
import rent.tycoon.domain.Rent;

public interface RentRepository {

    Rent saveRent(Rent rent);

}
