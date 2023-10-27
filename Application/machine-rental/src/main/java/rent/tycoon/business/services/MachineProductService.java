package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.boundaries.input.register.IMachineRegisterBoundary;
import rent.tycoon.business.boundaries.output.register.IMachineProductRegisterGateway;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.CreateMachineRequestModel;
import rent.tycoon.business.model.response.CreateMachineResponseModel;
import rent.tycoon.business.presenter.IMachinePresenter;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IMachineProductFactory;


@Service
@AllArgsConstructor
public class MachineProductService implements IMachineRegisterBoundary {
    IMachineProductFactory factory;
    IMachineProductRegisterGateway gateway;
    IMachinePresenter presenter;

    @Override
    public CreateMachineResponseModel create(CreateMachineRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsByName(requestModel.getName())){
            return presenter.prepareFailView(new ProductCustomException("Product with name " + requestModel.getName() + " already in database"));
        }
        IProduct machine = factory.create(0, requestModel.getName(), requestModel.getDescription(), requestModel.getStatus(), requestModel.getPrice());
        long id = gateway.save(machine);

        CreateMachineResponseModel responseModel = new CreateMachineResponseModel(id);

        return presenter.prepareSuccessView(responseModel);
    }
}
