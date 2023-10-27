package rent.tycoon.business.presenter;

import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.response.CreateRentResponseModel;

public interface IRentPresenter {
    CreateRentResponseModel prepareFailView (RentCustomException e ) throws RentCustomException;

    CreateRentResponseModel prepareSuccessView(CreateRentResponseModel responseModel);
}
