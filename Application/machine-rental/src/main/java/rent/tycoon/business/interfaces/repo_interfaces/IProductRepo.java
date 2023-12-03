package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.business.model.response.GetProductbyIdResponseModel;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Machine;

import java.util.List;

public interface IProductRepo extends IProductExistsGateway{
    long save(IProduct product);
    List<IProduct> findProductByName(String name);
    IProduct update(IProduct product);

    IProduct getProductbyId(Long id);
    List <IProduct> getMachineByCategory (Integer categoryId);

    List<IProduct> getAllProducts();
}
