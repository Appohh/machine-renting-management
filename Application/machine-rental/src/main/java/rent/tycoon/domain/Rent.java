package rent.tycoon.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Timestamp;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Rent {
    private long id;
    private long customerId;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
    private List<RentRow> rows;


}
