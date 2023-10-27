package rent.tycoon.domain.factory;

import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.IRent;
import rent.tycoon.domain.Image;

import java.math.BigDecimal;
import java.util.Date;

public interface IRentFactory {
    IRent create(int id, int productId, int customerId, Date start, Date end, String address, String city, Date timestamp, BigDecimal total, BigDecimal discount, int paid, Image image);
}
