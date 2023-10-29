package rent.tycoon.domain.factory;


import rent.tycoon.domain.IRent;
import java.math.BigDecimal;
import java.util.Date;

public interface IRentFactory {
    IRent create(long id, long productId, long customerId, Date start, Date end, String address, String city, Date timestamp, BigDecimal total, BigDecimal discount, int paid);
}
