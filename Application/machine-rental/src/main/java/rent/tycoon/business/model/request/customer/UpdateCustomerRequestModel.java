package rent.tycoon.business.model.request.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCustomerRequestModel {
    long id;
    String firstName ;
    String lastName;
    String address ;
    String city;
    String email;
    int phone;
}
