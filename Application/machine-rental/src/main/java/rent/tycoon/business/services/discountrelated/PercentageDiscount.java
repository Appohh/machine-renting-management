package rent.tycoon.business.services.discountrelated;

import rent.tycoon.business.interfaces.DiscountCodeType;

import java.math.BigDecimal;

public class PercentageDiscount implements DiscountCodeType {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscountAmount(double originalPrice) {
        return originalPrice * (percentage / 100);
    }
}
