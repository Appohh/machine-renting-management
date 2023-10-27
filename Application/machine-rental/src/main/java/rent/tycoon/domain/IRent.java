package rent.tycoon.domain;

import java.math.BigDecimal;
import java.util.Date;

public interface IRent {
     long id();
     int productId();
     int customerId();
     Date start();
     Date end();
     String address();
     String city();
     Date timestamp();
     BigDecimal total();
     BigDecimal discount();
     int paid();
     Image image();
}
