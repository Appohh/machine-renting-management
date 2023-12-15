package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Rent2;

import java.util.Map;

public interface IRentRepo2 {
    long save (Rent2 rent);
    Map<Rent2, IProduct> getRentsAndProductsByCustomerId(long customerId);
}
