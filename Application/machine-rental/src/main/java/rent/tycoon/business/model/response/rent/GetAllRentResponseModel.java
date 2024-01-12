package rent.tycoon.business.model.response.rent;

import lombok.*;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Rent2;
import rent.tycoon.domain.RentProductWrapper;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetAllRentResponseModel {
    private List<RentProductWrapper> rentProductList;
}
