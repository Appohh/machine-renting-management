package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@Getter
@Builder
public class Rent {
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
