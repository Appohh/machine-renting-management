package rent.tycoon.adapter.presenter;

import org.springframework.stereotype.Service;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.response.CreateMachineResponseModel;
import rent.tycoon.business.presenter.IMachinePresenter;

import java.util.List;

@Service
public class MachinePresenter implements IMachinePresenter {
    @Override
    public CreateMachineResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException{
        throw e;
    }

    @Override
    public CreateMachineResponseModel prepareSuccessView(CreateMachineResponseModel responseModel){
        return responseModel;
    }
}
