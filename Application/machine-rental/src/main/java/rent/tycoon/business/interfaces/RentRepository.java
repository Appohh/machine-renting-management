package rent.tycoon.business.interfaces;

import rent.tycoon.domain.Rent;

public interface RentRepository {

    Rent saveRent(Rent createRent);

}
