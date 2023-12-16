package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Rent2;

import java.util.List;
import java.util.Map;

public interface IRentRepo2 {
    long save (Rent2 rent);
    List<Rent2> getRentsByCustomerId(long customerId);

    IProduct getProductByRent (long rentId);
}
