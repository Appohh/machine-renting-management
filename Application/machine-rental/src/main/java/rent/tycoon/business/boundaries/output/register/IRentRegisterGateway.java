package rent.tycoon.business.boundaries.output.register;

import rent.tycoon.domain.IRent;
import rent.tycoon.domain.Rent;

public interface IRentRegisterGateway extends IRentExistsGateway {
    long save (IRent rent);
}

