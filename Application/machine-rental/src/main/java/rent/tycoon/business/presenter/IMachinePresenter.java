package rent.tycoon.business.presenter;

import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.response.CreateProductResponseModel;
import rent.tycoon.business.model.response.GetProductResponseModel;

public interface IMachinePresenter {
    CreateProductResponseModel prepareFailView (ProductCustomException e) throws ProductCustomException;

    CreateProductResponseModel prepareSuccessView(CreateProductResponseModel responseModel);

    GetProductResponseModel prepareGetFailView (ProductCustomException e) throws ProductCustomException;

    GetProductResponseModel prepareGetSuccessView(GetProductResponseModel responseModel);


}
