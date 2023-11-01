package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.service_interfaces.IRentService;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;
import rent.tycoon.domain.Rent;

import java.util.Date;

@Service
@AllArgsConstructor
public class RentService implements IRentService {
    IRentRepo gateway;

    @Override
    public CreateRentResponseModel create(CreateRentRequestModel requestModel) throws RentCustomException{
        if (gateway.existsByProductId(requestModel.getProductId())){
            throw new RentCustomException("Rent with the productId" + requestModel.getProductId() + " Already in database");
        }

        Rent rent = new Rent(0, requestModel.getProductId(), requestModel.getCustomerId(), requestModel.getStart(), requestModel.getEnd(), requestModel.getAddress(), requestModel.getCity(), new Date(), requestModel.getTotal(), requestModel.getDiscount(), 0);

        long id = gateway.save(rent);

        return new CreateRentResponseModel(id);
    }
}
