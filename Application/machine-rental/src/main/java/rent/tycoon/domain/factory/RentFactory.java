package rent.tycoon.domain.factory;

import org.springframework.context.annotation.Configuration;
import rent.tycoon.domain.Rent;

import java.math.BigDecimal;
import java.util.Date;

@Configuration
public class RentFactory implements IRentFactory{

    @Override
    public Rent create(long id, long productId, long customerId, Date start, Date end, String address, String city, Date timestamp, BigDecimal total, BigDecimal discount, int paid){
        return new Rent(id,productId,customerId,start,end, address, city, timestamp, total, discount, paid);
    }
}
