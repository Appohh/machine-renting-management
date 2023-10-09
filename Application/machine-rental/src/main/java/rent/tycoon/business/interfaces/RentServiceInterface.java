package rent.tycoon.business.interfaces;

import rent.tycoon.domain.Product;

public interface RentServiceInterface {
    /* Idk wat hier de bedoeling is
    public Product CreateRent(CreateRent createRent);
    */
    public boolean BoolIsAvailable(long id);
}
