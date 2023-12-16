package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo2;
import rent.tycoon.business.interfaces.service_interfaces.IRentService2;
import rent.tycoon.business.model.request.CreateRentRequest2;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;
import rent.tycoon.business.model.response.GetAllRentResponseModel;
import rent.tycoon.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RentService2 implements IRentService2 {
    IRentRepo2 repo;

    @Override
    public CreateRentResponseModel create(CreateRentRequest2 requestModel) throws RentCustomException {
        Rent2 rent = new Rent2(0, requestModel.getCustomerId(), requestModel.getAddress(), requestModel.getCity(), new Date(), BigDecimal.valueOf(0), BigDecimal.valueOf(0), 1, requestModel.getProductId(), requestModel.getStartDate(),requestModel.getEndDate());

        long id = repo.save(rent);

        return CreateRentResponseModel.builder()
                .rentId(id)
                .build();
    }

    @Override
    public GetAllRentResponseModel getAllRents(long customerId) throws RentCustomException {
        List<RentProductWrapper> rentProductList = new ArrayList<>();
        List<Rent2> rents = repo.getRentsByCustomerId(customerId);

        for (Rent2 rent : rents) {
            IProduct product = repo.getProductByRent(rent.getId());

            RentProductWrapper rentProductWrapper = new RentProductWrapper(rent, product);
            rentProductList.add(rentProductWrapper);
        }

        return new GetAllRentResponseModel(rentProductList);
    }
}
