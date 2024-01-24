package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.DiscountCode;

public interface IDiscountRepo {
    DiscountCode checkDiscountCode(String code);
}
