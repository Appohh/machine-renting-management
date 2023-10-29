package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.boundaries.input.register.IMachineRegisterBoundary;
import rent.tycoon.business.boundaries.output.register.IMachineProductRegisterGateway;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.CreateMachineRequestModel;
import rent.tycoon.business.model.response.CreateMachineResponseModel;
import rent.tycoon.business.presenter.IMachinePresenter;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IMachineProductFactory;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class MachineProductService implements IMachineRegisterBoundary {
    IMachineProductFactory factory;
    IMachineProductRegisterGateway gateway;
    IMachinePresenter presenter;
    StorageService storageService;

    @Override
    public CreateMachineResponseModel create(CreateMachineRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsByName(requestModel.getName())){
            return presenter.prepareFailView(new ProductCustomException("Product with name " + requestModel.getName() + " already in database"));
        }
        long result = 0;
        List<Files> files = new ArrayList<>();
        for (MultipartFile file : requestModel.getFiles()){
            files.add(Files.builder()
                            .fileUrl(file.getOriginalFilename())
                            .type(file.getContentType())
                            .build());
        }
        try {
            IProduct machine = factory.create(0, requestModel.getName(), requestModel.getDescription(), requestModel.getStatus(), requestModel.getPrice(), files);
            result = gateway.save(machine);

            if (result != 0) {
                for (MultipartFile file : requestModel.getFiles()) {
                    storageService.store(file, result);
                }
            } else {
                return presenter.prepareFailView(new ProductCustomException("Something went wrong with id: " + result));
            }
        } catch (Exception e) {
            return presenter.prepareFailView(new ProductCustomException("Save was unsuccessful"));
        }
        CreateMachineResponseModel responseModel = new CreateMachineResponseModel(result);

        return presenter.prepareSuccessView(responseModel);
    }
}
