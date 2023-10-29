package rent.tycoon.business.boundaries.output.register;

import rent.tycoon.domain.IRent;


public interface IRentRegisterGateway extends IRentExistsGateway {
    long save (IRent rent);
}

