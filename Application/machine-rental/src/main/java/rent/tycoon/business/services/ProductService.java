package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.boundaries.input.IProductBoundary;
import rent.tycoon.business.boundaries.output.IProductRegisterGateway;
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
import rent.tycoon.business.presenter.IMachinePresenter;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductService implements IProductBoundary {
    IProductFactory factory;
    IProductRegisterGateway gateway;
    IMachinePresenter presenter;
    StorageService storageService;

    @Override
    public CreateProductResponseModel create(CreateProductRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsByName(requestModel.getName())) {
            throw new ProductCustomException("Product with name " + requestModel.getName() + " already exists in the database");
        }

        List<Files> files = requestModel.getFiles().stream()
                .map(file -> Files.builder()
                        .fileUrl(file.getOriginalFilename())
                        .type(file.getContentType())
                        .build())
                .collect(Collectors.toList());

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

        CreateProductResponseModel responseModel = new CreateProductResponseModel(result);
        return presenter.prepareSuccessView(responseModel);
    }

    @Override
    public GetProductResponseModel findProductByName(String name) throws ProductCustomException {
        List<IProduct> iProducts;
        try {
            iProducts = gateway.findProductByName(name);
            }
        catch (Exception e){
            return presenter.prepareGetFailView(new ProductCustomException("Retrieval was unsuccessful"));
        }

        GetProductResponseModel responseModel = new GetProductResponseModel(iProducts);
        return presenter.prepareGetSuccessView(responseModel);
    }

    @Override
    public UpdateProductResponseModel update(UpdateProductRequestModel requestModel) throws ProductCustomException {
        // Verificar si el producto con el ID proporcionado existe
        if (!gateway.existsById(String.valueOf(requestModel.getId()))) {
            throw new ProductCustomException("Product with ID " + requestModel.getId() + " does not exist in the database");
        }

        // Mapear los archivos desde el requestModel a la lista de Files
        List<Files> files = requestModel.getFiles().stream()
                .map(file -> Files.builder()
                        .fileUrl(file.getOriginalFilename())
                        .type(file.getContentType())
                        .build())
                .collect(Collectors.toList());

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

        // Actualizar el producto en el gateway
        IProduct product = gateway.update(updatedProduct);

        // Puedes agregar lógica adicional aquí, como manejar la actualización de archivos si es necesario

        return new UpdateProductResponseModel(product);
    }




}
