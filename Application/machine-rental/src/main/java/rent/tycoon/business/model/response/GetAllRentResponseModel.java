package rent.tycoon.business.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Rent2;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class GetAllRentResponseModel {
    private Map<Rent2, IProduct> rentProductMap;

}
