package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.IProduct;

import java.util.List;

public interface IProductRepo extends IProductExistsGateway{
    long save(IProduct product);
    List<IProduct> findProductByName(String name);
    IProduct update(IProduct product);
}
