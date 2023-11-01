package rent.tycoon.business.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import rent.tycoon.domain.IProduct;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetProductResponseModel {
    List <IProduct> products;
}
