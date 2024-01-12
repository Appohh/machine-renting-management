package rent.tycoon.business.interfaces.service_interfaces;

import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequest2;
import rent.tycoon.business.model.response.rent.CreateRentResponseModel;
import rent.tycoon.business.model.response.rent.GetAllRentResponseModel;

public interface IRentService2 {
    CreateRentResponseModel create(CreateRentRequest2 responseModel) throws RentCustomException;
    GetAllRentResponseModel getAllRents (long customerId) throws RentCustomException;
}
