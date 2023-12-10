package rent.tycoon.business.model.request.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogInRequestModel {
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String password;
}
