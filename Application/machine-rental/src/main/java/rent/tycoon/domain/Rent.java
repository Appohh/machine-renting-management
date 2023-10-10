package rent.tycoon.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Rent {
    @Setter
    private int id;
    private int productId;
    private int customerId;
    private Date start;
    private Date end;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
}
