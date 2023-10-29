package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.boundaries.input.register.IRentRegisterBoundary;
import rent.tycoon.business.boundaries.output.register.IRentRegisterGateway;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;
import rent.tycoon.business.presenter.IRentPresenter;
import rent.tycoon.domain.IRent;
import rent.tycoon.domain.factory.IRentFactory;

import java.util.Date;

@Service
@AllArgsConstructor
public class RentService implements IRentRegisterBoundary {
    IRentRegisterGateway gateway;
    IRentPresenter presenter;
    IRentFactory factory;

    @Override
    public CreateRentResponseModel create(CreateRentRequestModel requestModel) throws RentCustomException{
        if (gateway.existsByProductId(requestModel.getProductId())){
            return presenter.prepareFailView(new RentCustomException("Rent with the productId" + requestModel.getProductId() + " Already in database"));
        }

        IRent rent = factory.create(0, requestModel.getProductId(), requestModel.getCustomerId(), requestModel.getStart(), requestModel.getEnd(), requestModel.getAddress(), requestModel.getCity(), new Date(), requestModel.getTotal(), requestModel.getDiscount(), 0);

        long id = gateway.save(rent);

        CreateRentResponseModel responseModel = new CreateRentResponseModel(id);

        return presenter.prepareSuccessView(responseModel);
    }
}
