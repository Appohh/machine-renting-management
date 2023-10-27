package rent.tycoon.business.presenter;

import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.response.CreateMachineResponseModel;

public interface IMachinePresenter {
    CreateMachineResponseModel prepareFailView (ProductCustomException e) throws ProductCustomException;

    CreateMachineResponseModel prepareSuccessView(CreateMachineResponseModel responseModel);


}
