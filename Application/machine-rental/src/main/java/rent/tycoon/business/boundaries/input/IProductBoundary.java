package rent.tycoon.business.boundaries.input;

import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.GetProductRequestModel;
import rent.tycoon.business.model.request.create.CreateProductRequestModel;
import rent.tycoon.business.model.response.CreateProductResponseModel;
import rent.tycoon.business.model.response.GetProductResponseModel;

public interface IProductBoundary {
    CreateProductResponseModel create(CreateProductRequestModel requestModel) throws ProductCustomException;

    GetProductResponseModel findProductByName(String name) throws ProductCustomException;
}
