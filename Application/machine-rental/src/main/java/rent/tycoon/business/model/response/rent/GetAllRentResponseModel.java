package rent.tycoon.business.model.response.rent;

import lombok.*;
import rent.tycoon.domain.RentProductWrapper;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetAllRentResponseModel {
    private List<RentProductWrapper> rentProductList;
}
