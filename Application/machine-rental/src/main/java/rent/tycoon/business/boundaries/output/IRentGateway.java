package rent.tycoon.business.boundaries.output;

import rent.tycoon.domain.Rent;

public interface IRentGateway extends IRentExistsGateway{
    long save (Rent rent);
}
