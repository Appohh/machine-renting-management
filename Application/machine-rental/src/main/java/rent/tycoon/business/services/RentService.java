package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.service_interfaces.IRentService;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.rent.AddRentRowRequestModel;
import rent.tycoon.business.model.request.rent.CreateRentRequestModel;
import rent.tycoon.business.model.response.rent.AddRentRowResponseModel;
import rent.tycoon.business.model.response.rent.CreateRentResponseModel;
import rent.tycoon.business.model.response.rent.GetAllRentResponseModel;
import rent.tycoon.business.model.response.rent.GetAllRentRowsResponseModel;
import rent.tycoon.domain.*;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService implements IRentService {
    IRentRepo gateway;

    @Override
    public CreateRentResponseModel create(CreateRentRequestModel requestModel) throws RentCustomException{

        //ff test
        if (requestModel.getCustomerId() == 0) {
            throw new RentCustomException("Customer has invalid id");
        }

        Rent rent = new Rent(0, requestModel.getCustomerId(), requestModel.getAddress(), requestModel.getCity(), new Date(), requestModel.getTotal(), requestModel.getDiscount(), 0);

        long id = gateway.save(rent);

        return CreateRentResponseModel.builder()
                .rentId(id)
                .build();
    }

    public Boolean userOwnsRent(long userId, long rentId){
        Optional<Rent> rentOptional = gateway.findByRentId(rentId);

        if (rentOptional.isPresent()) {
            Rent rent = rentOptional.get();
            return rent.getCustomerId() == userId;
        }

        return false;
    }

    public AddRentRowResponseModel addRentRow(AddRentRowRequestModel requestModel) throws RentCustomException{
        RentRow rentRow = new RentRow(0, requestModel.getProductId(), requestModel.getStartDate(), requestModel.getEndDate(), requestModel.getRentId());
        try {
            long id = gateway.saveRentRow(rentRow);
            return new AddRentRowResponseModel(id);
        }catch(Exception e){
            throw new RentCustomException("Something went wrong.");
        }


    }

    public GetAllRentResponseModel getAllRents(long customerId) throws RentCustomException{
        try {
            List<Rent> rents = gateway.getAllRents(customerId);
            return new GetAllRentResponseModel(rents);
        }catch(Exception e){
            throw new RentCustomException("Something went wrong.");
        }
    }

    public GetAllRentRowsResponseModel getAllRentRows(long rentId) throws RentCustomException{
        try {
            List<RentRow> rentRows = gateway.getAllRentRows(rentId);
            return new GetAllRentRowsResponseModel(rentRows);
        }catch(Exception e){
            throw new RentCustomException("Something went wrong.");
        }
    }

}
