package rent.tycoon.business.boundaries.input.register;

import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.CreateMachineRequestModel;
import rent.tycoon.business.model.response.CreateMachineResponseModel;

public interface IMachineRegisterBoundary {
    CreateMachineResponseModel create(CreateMachineRequestModel requestModel) throws ProductCustomException;
}
