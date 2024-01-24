package rent.tycoon.business.services.discountrelated;

import rent.tycoon.business.interfaces.DiscountCodeType;


public class FixedAmountDiscount  implements DiscountCodeType {
    private final double amount;

    public FixedAmountDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscountAmount(double originalPrice) {
        return amount;
    }
}
