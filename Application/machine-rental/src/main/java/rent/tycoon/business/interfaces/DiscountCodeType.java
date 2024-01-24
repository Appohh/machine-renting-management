package rent.tycoon.business.interfaces;

import java.math.BigDecimal;

public interface DiscountCodeType {
    double calculateDiscountAmount(double originalPrice);
}
