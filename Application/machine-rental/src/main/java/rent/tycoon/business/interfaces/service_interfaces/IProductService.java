package rent.tycoon.business.interfaces.service_interfaces;

import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.product.CreateProductRequestModel;
import rent.tycoon.business.model.request.product.UpdateProductRequestModel;
import rent.tycoon.business.model.response.product.*;
import rent.tycoon.domain.Category;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Machine;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    CreateProductResponseModel create(CreateProductRequestModel requestModel) throws ProductCustomException;

    GetProductResponseModel findProductByName(String name) throws ProductCustomException;
    UpdateProductResponseModel update(UpdateProductRequestModel requestModel) throws ProductCustomException;
    GetProductbyIdResponseModel getProductById(Long id);
    FilterMachineResponseModel getMachineByCategory (Integer categoryId);

    GetProductResponseModel getAllProducts () throws ProductCustomException;
    GetProductResponseModel filterProduct(String name, int price, long category);

    GetProductResponseModel filterAndSortProducts(String name, BigDecimal maxPrice, Integer category);

}
