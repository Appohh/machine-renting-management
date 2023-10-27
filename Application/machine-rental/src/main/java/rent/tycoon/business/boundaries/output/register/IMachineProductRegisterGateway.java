package rent.tycoon.business.boundaries.output.register;

import rent.tycoon.domain.IProduct;

public interface IMachineProductRegisterGateway extends IProductExistsGateway {
    long save (IProduct iProduct);
}
