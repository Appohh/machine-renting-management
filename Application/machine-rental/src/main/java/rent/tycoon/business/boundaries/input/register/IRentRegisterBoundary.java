package rent.tycoon.business.boundaries.input.register;

import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateMachineResponseModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;

public interface IRentRegisterBoundary {
    CreateRentResponseModel create(CreateRentRequestModel responseModel) throws RentCustomException;
}
