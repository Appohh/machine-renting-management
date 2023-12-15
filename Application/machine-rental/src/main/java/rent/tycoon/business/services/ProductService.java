package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.interfaces.service_interfaces.IProductService;
import rent.tycoon.business.interfaces.repo_interfaces.IProductRepo;
import rent.tycoon.business.converter.FileConverter;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.accessory.UpdateAccessoryRequestModel;
import rent.tycoon.business.model.request.machine.UpdateMachineRequestModel;
import rent.tycoon.business.model.request.product.UpdateProductRequestModel;
import rent.tycoon.business.model.request.accessory.CreateAccessoryRequestModel;
import rent.tycoon.business.model.request.machine.CreateMachineRequestModel;
import rent.tycoon.business.model.request.product.CreateProductRequestModel;
import rent.tycoon.business.model.response.*;
import rent.tycoon.domain.Category;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.List;
import java.util.Objects;


@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    IProductFactory factory;
    IProductRepo gateway;
    StorageService storageService;

    @Override
    public CreateProductResponseModel create(CreateProductRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsByName(requestModel.getName())) {
            throw new ProductCustomException("Product with name " + requestModel.getName() + " already exists in the database");
        }

        List <Files> files = FileConverter.convertToFileObject(requestModel.getFiles());

        IProduct product;
        if ( requestModel instanceof CreateMachineRequestModel machineRequestModel){
            product = factory.createMachine(0, machineRequestModel.getName(), machineRequestModel.getDescription(), machineRequestModel.getStatus(), machineRequestModel.getPrice(), files, machineRequestModel.getMachineSpecificField(), machineRequestModel.getCategory());
        } else if ( requestModel instanceof CreateAccessoryRequestModel accessoryRequestModel){
            product = factory.createAccessory(0, accessoryRequestModel.getName(), accessoryRequestModel.getDescription(), accessoryRequestModel.getStatus(), accessoryRequestModel.getPrice(), files,  accessoryRequestModel.getAccessorySpecificField());
        } else {
            throw new ProductCustomException("Invalid product type: ");
        }

        long result = gateway.save(product);

        if (result != 0) {
            for (MultipartFile file : requestModel.getFiles()) {
                storageService.store(file, result);
            }
        } else {
            throw new ProductCustomException("Something went wrong with id: " + result);
        }

        return new CreateProductResponseModel(result);
    }

    @Override
    public GetProductResponseModel findProductByName(String name) throws ProductCustomException {
        List<IProduct> iProducts;
        try {
            iProducts = gateway.findProductByName(name);
            }
        catch (Exception e){
            throw new ProductCustomException("Problem with finding products");
        }

        return new GetProductResponseModel(iProducts);
    }

    @Override
    public UpdateProductResponseModel update(UpdateProductRequestModel requestModel) throws ProductCustomException {
        if (!gateway.existsById(String.valueOf(requestModel.getId()))) {
            throw new ProductCustomException("Product with ID " + requestModel.getId() + " does not exist in the database");
        }

        List <Files> files = FileConverter.convertToFileObject(requestModel.getFiles());

        IProduct updatedProduct;
        if ( requestModel instanceof UpdateMachineRequestModel machineRequestModel){
            updatedProduct = factory.createMachine(machineRequestModel.getId(), machineRequestModel.getName(), machineRequestModel.getDescription(), machineRequestModel.getStatus(), machineRequestModel.getPrice(), files, machineRequestModel.getMachineSpecificField(), machineRequestModel.getCategory());
        } else if ( requestModel instanceof UpdateAccessoryRequestModel accessoryRequestModel){
            updatedProduct = factory.createAccessory(accessoryRequestModel.getId(), accessoryRequestModel.getName(), accessoryRequestModel.getDescription(), accessoryRequestModel.getStatus(), accessoryRequestModel.getPrice(), files,  accessoryRequestModel.getAccessorySpecificField());
        } else {
            throw new ProductCustomException("Invalid product type: ");
        }

        IProduct product = gateway.update(updatedProduct);

        return new UpdateProductResponseModel(product);
    }

    @Override
    public GetProductbyIdResponseModel getProductById(Long id){
        IProduct product = gateway.getProductById(id);
        return new GetProductbyIdResponseModel(product);
    }

    @Override
    public FilterMachineResponseModel getMachineByCategory (Integer categoryId){
        List<IProduct> products = gateway.getMachineByCategory(categoryId);
        return new FilterMachineResponseModel(products);
    }

    @Override
    public GetProductResponseModel getAllProducts () throws ProductCustomException{
        try{
            List<IProduct> products = gateway.getAllProducts();
            return new GetProductResponseModel(products);
        }
        catch (Exception e){
            throw new ProductCustomException("Problem with finding products");
        }


    }
    @Override
    public GetProductResponseModel filterProduct(String name, int price, Category category){
        try{
            List<IProduct> products= gateway.filterProduct(name, price, category);
            return new GetProductResponseModel(products);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Something went wrong");
        }

    }
}
