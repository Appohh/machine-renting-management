package rent.tycoon.business.model.request.rent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
public class AddRentRowRequestModel {
    private long productId;
    private Date startDate;
    private Date endDate;
    private long rentId;
    private Integer quantity;
}
