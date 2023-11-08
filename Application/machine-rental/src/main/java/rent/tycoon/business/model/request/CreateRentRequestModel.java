package rent.tycoon.business.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rent.tycoon.domain.RentRow;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentRequestModel {
    private int customerId;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
    private List<RentRow>rows;
}
