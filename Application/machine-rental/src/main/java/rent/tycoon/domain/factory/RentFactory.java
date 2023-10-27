package rent.tycoon.domain.factory;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.domain.Image;
import rent.tycoon.domain.Machine;
import rent.tycoon.domain.Rent;

import java.math.BigDecimal;
import java.util.Date;

@Configuration
public class RentFactory implements IRentFactory{

    @Override
    public Rent create(int id, int productId, int customerId, Date start, Date end, String address, String city, Date timestamp, BigDecimal total, BigDecimal discount, int paid, Image image){
        return new Rent(id,productId,customerId,start,end, address, city, timestamp, total, discount, paid, image);
    }
}
