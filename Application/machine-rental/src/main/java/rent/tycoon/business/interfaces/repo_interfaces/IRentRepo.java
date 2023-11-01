package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.Rent;

public interface IRentRepo extends IRentExistsGateway{
    long save (Rent rent);
}
