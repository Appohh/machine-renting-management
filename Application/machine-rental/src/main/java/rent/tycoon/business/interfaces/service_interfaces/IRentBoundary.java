package rent.tycoon.business.interfaces.service_interfaces;

import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;

public interface IRentBoundary {
    CreateRentResponseModel create(CreateRentRequestModel responseModel) throws RentCustomException;
}
