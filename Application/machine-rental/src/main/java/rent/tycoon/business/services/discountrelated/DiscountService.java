package rent.tycoon.business.services.discountrelated;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.DiscountCodeType;
import rent.tycoon.business.interfaces.repo_interfaces.IDiscountRepo;
import rent.tycoon.business.interfaces.repo_interfaces.IUserRepo;
import rent.tycoon.business.interfaces.service_interfaces.IDiscountService;
import rent.tycoon.business.model.request.discount.DiscountRequestModel;
import rent.tycoon.business.model.response.discount.DiscountResponseModel;
import rent.tycoon.domain.Customer;
import rent.tycoon.domain.DiscountCode;

import java.time.LocalDate;


@Service
@AllArgsConstructor
public class DiscountService implements IDiscountService {
    private final IDiscountRepo repo;
    private final IUserRepo userRepo;
    public DiscountResponseModel applyDiscount(DiscountRequestModel discountRequestModel, long userId){
        double discountAmount = 0.0;

        try {
            DiscountCode discountCode = checkDiscountCode(discountRequestModel.getCode());
            Customer user = userRepo.getUserById(userId);

            if (discountCode != null) {
                DiscountCodeType discountCodeType = createDiscountCodeType(discountCode.getType(), discountCode.getValue());
                discountAmount = discountCodeType.calculateDiscountAmount(discountRequestModel.getTotal());
            } else if (user.getBirthdate().equals(LocalDate.now())) {
                DiscountCodeType discountCodeType = createDiscountCodeType("Birthday", 5);
                discountAmount = discountCodeType.calculateDiscountAmount(discountRequestModel.getTotal());
            }
            return new DiscountResponseModel(discountAmount, discountRequestModel.getCode());
           } catch (Exception e){
            throw e;
        }
    }

    private DiscountCode checkDiscountCode(String code){
        return repo.checkDiscountCode(code);
    }

    private DiscountCodeType createDiscountCodeType(String discountTypeString, double value) {
        return switch (discountTypeString) {
            case "Percentage" -> new PercentageDiscount(value);
            case "FixedAmount" -> new FixedAmountDiscount(value);
            case "Birthday" -> new BirthdayDiscount(value);
            default -> throw new IllegalArgumentException("Unknown discount type: " + discountTypeString);
        };
    }
}
