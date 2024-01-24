package rent.tycoon.business.model.request.discount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter

public class DiscountRequestModel {
    private double total;
    private String code;
}
