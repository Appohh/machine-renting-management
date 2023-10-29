package rent.tycoon.domain;

import java.math.BigDecimal;
import java.util.Date;

public interface IRent {
     long getId();
     long getProductId();
     long getCustomerId();
     Date getStart();
     Date getEnd();
     String getAddress();
     String getCity();
     Date getTimestamp();
     BigDecimal getTotal();
     BigDecimal getDiscount();
     int getPaid();
}
