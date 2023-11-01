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
import rent.tycoon.business.model.response.CreateProductResponseModel;
import rent.tycoon.business.model.response.GetProductResponseModel;
import rent.tycoon.business.model.response.UpdateProductResponseModel;
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
        if (Objects.equals(requestModel.getType(), "machine")) {
            CreateMachineRequestModel machineRequestModel = (CreateMachineRequestModel) requestModel;
            product = factory.createMachine(0, requestModel.getName(), requestModel.getDescription(), requestModel.getStatus(), requestModel.getPrice(), files, requestModel.getType(), machineRequestModel.getMachineSpecificField());
        } else if (Objects.equals(requestModel.getType(), "accessory")) {
            CreateAccessoryRequestModel accessoryRequestModel = (CreateAccessoryRequestModel) requestModel;
            product = factory.createAccessory(0, requestModel.getName(), requestModel.getDescription(), requestModel.getStatus(), requestModel.getPrice(), files, requestModel.getType(),  accessoryRequestModel.getAccessorySpecificField());
        } else {
            throw new ProductCustomException("Invalid product type: " + requestModel.getType());
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
        if (Objects.equals(requestModel.getType(), "machine")) {
            UpdateMachineRequestModel machineRequestModel = (UpdateMachineRequestModel) requestModel;
            updatedProduct = factory.createMachine(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getStatus(), requestModel.getPrice(), files, requestModel.getType(), machineRequestModel.getMachineSpecificField());
        } else if (Objects.equals(requestModel.getType(), "accessory")) {
            UpdateAccessoryRequestModel accessoryRequestModel = (UpdateAccessoryRequestModel) requestModel;
            updatedProduct = factory.createAccessory(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getStatus(), requestModel.getPrice(), files, requestModel.getType(), accessoryRequestModel.getAccessorySpecificField());
        } else {
            throw new ProductCustomException("Invalid product type: " + requestModel.getType());
        }

        IProduct product = gateway.update(updatedProduct);

        return new UpdateProductResponseModel(product);
    }




}
