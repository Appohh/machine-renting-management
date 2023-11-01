package rent.tycoon.adapter.presenter;

import org.springframework.stereotype.Service;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.response.CreateProductResponseModel;
import rent.tycoon.business.model.response.GetProductResponseModel;
import rent.tycoon.business.presenter.IMachinePresenter;

@Service
public class MachinePresenter implements IMachinePresenter {
    @Override
    public CreateProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException{
        throw e;
    }

    @Override
    public CreateProductResponseModel prepareSuccessView(CreateProductResponseModel responseModel){
        return responseModel;
    }

    @Override
    public GetProductResponseModel prepareGetFailView(ProductCustomException e) throws ProductCustomException{
        throw e;
    }

    @Override
    public GetProductResponseModel prepareGetSuccessView(GetProductResponseModel responseModel){
        return responseModel;
    }

}
