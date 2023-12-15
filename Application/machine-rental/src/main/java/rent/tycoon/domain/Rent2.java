package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Rent2 {
    private long id;
    private long customerId;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
    private long productId;
    private Date startDate;
    private Date endDate;
}
