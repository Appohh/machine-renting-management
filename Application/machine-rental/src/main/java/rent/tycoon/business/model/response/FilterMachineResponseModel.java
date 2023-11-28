package rent.tycoon.business.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rent.tycoon.domain.IProduct;

import java.util.List;

@Getter
@AllArgsConstructor
public class FilterMachineResponseModel {
    List<IProduct> products;
}
