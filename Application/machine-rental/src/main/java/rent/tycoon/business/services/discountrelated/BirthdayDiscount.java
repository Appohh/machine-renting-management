package rent.tycoon.business.services.discountrelated;

import rent.tycoon.business.interfaces.DiscountCodeType;

public class BirthdayDiscount implements DiscountCodeType {
    private final double amount;

    public BirthdayDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscountAmount(double originalPrice) {
        return originalPrice - amount;
    }
}
