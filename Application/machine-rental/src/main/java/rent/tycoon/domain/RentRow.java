package rent.tycoon.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class RentRow {
    private long id;
    private long productId;
    private Date startDate;
    private Date endDate;
    private long rentId;
    private Integer quantity;
}
