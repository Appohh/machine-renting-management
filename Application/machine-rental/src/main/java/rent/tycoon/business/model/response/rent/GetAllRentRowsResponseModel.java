package rent.tycoon.business.model.response.rent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rent.tycoon.domain.RentProductWrapper;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetAllRentRowsResponseModel {
    private List<RentProductWrapper> rentWrapper;
}
