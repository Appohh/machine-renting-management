package rent.tycoon.adapter.presenter;

import org.springframework.stereotype.Service;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.response.CreateRentResponseModel;
import rent.tycoon.business.presenter.IRentPresenter;
@Service
public class RentPresenter implements IRentPresenter {
    @Override
    public CreateRentResponseModel prepareFailView(RentCustomException e) throws RentCustomException{
        throw e;
    }

    @Override
    public CreateRentResponseModel prepareSuccessView (CreateRentResponseModel responseModel){
        return responseModel;
    }
}
