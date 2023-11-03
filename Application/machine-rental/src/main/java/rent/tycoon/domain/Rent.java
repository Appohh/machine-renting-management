package rent.tycoon.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Rent {
    private long id;
    //Hier nog een list van maken. Maakt mogelijk dat een user meerdere producten kan renten tegelijkertijds
    private long userId;
    private long productId;
    private long customerId;
    private Date start;
    private Date end;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;

}
