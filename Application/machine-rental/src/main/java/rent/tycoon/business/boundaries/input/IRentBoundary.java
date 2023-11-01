package rent.tycoon.business.boundaries.input;

import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.create.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;

public interface IRentBoundary {
    CreateRentResponseModel create(CreateRentRequestModel responseModel) throws RentCustomException;
}
