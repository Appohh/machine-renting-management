package rent.tycoon.business.model.request.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequestModel {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Date birthdate;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    private String email;
    @NotNull
    private int phone;

    //no TimeStamp because its new date


    private String password;
}
