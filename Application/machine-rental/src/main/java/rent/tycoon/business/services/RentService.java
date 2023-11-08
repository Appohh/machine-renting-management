package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.service_interfaces.IRentService;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.RentRow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class RentService implements IRentService {
    IRentRepo gateway;

    @Override
    public CreateRentResponseModel create(CreateRentRequestModel requestModel) throws RentCustomException{

        //ff test
        if (requestModel.getTotal() == null) {
            throw new RentCustomException("Product with total is null");
        }

        List<RentRow> rows = new ArrayList<>(requestModel.getRows());

        Rent rent = new Rent(0, requestModel.getCustomerId(), requestModel.getAddress(), requestModel.getCity(), new Date(), requestModel.getTotal(), requestModel.getDiscount(), 0,rows);

        long id = gateway.save(rent);

        return CreateRentResponseModel.builder()
                .rentId(id)
                .build();
    }
}
