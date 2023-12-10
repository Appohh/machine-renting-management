package rent.tycoon.business.model.response.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import rent.tycoon.domain.Customer;

@Getter
@AllArgsConstructor
@Builder
public class GetCustomerResponseModel {
    private Customer user;
}
