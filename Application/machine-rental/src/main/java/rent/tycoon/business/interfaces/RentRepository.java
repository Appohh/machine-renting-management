package rent.tycoon.business.interfaces;

import rent.tycoon.domain.CreateRent;

public interface RentRepository {

    CreateRent saveRent(CreateRent createRent);

}
