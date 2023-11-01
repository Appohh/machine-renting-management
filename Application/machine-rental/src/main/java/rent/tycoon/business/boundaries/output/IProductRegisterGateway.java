package rent.tycoon.business.boundaries.output;

import rent.tycoon.domain.IProduct;

import java.util.List;

public interface IProductRegisterGateway extends IProductExistsGateway{
    long save(IProduct product);
    List<IProduct> findProductByName(String name);
}
