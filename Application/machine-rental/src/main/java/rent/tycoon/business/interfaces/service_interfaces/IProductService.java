package rent.tycoon.business.interfaces.service_interfaces;

import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.product.CreateProductRequestModel;
import rent.tycoon.business.model.request.product.UpdateProductRequestModel;
import rent.tycoon.business.model.response.*;

public interface IProductService {
    CreateProductResponseModel create(CreateProductRequestModel requestModel) throws ProductCustomException;

    GetProductResponseModel findProductByName(String name) throws ProductCustomException;
    UpdateProductResponseModel update(UpdateProductRequestModel requestModel) throws ProductCustomException;
    GetProductbyIdResponseModel getProductbyId(Long id);
    FilterMachineResponseModel getMachineByCategory (Integer categoryId);
}
