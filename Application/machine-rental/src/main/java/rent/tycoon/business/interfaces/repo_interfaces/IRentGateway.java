package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.Rent;

public interface IRentGateway extends IRentExistsGateway{
    long save (Rent rent);
}
