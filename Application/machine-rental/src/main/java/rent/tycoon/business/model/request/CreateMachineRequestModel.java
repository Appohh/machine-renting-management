package rent.tycoon.business.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
public class CreateMachineRequestModel {
    private String name;
    private String description;
    private int status;
    private BigDecimal price;

}
