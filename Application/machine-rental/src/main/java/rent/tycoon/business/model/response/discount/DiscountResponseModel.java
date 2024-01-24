package rent.tycoon.business.model.response.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class DiscountResponseModel {
    private double discountAmount;
    private String code;
}
