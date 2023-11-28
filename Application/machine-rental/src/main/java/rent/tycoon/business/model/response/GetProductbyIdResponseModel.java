package rent.tycoon.business.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rent.tycoon.domain.IProduct;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GetProductbyIdResponseModel {
    IProduct product;
}
