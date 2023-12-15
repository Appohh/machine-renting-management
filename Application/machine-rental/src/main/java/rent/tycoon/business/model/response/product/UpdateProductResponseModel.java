package rent.tycoon.business.model.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import rent.tycoon.domain.IProduct;

@Getter
@Builder
@AllArgsConstructor
public class UpdateProductResponseModel {
    IProduct product;
}
