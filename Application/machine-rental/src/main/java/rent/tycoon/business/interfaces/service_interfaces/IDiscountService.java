package rent.tycoon.business.interfaces.service_interfaces;

import rent.tycoon.business.model.request.discount.DiscountRequestModel;
import rent.tycoon.business.model.response.discount.DiscountResponseModel;

public interface IDiscountService {
    DiscountResponseModel applyDiscount(DiscountRequestModel discountRequestModel, long userId);
}
