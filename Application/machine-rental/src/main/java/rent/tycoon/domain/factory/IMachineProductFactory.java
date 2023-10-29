package rent.tycoon.domain.factory;

import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;

import java.math.BigDecimal;
import java.util.List;

public interface IMachineProductFactory {
    IProduct create(long id, String name, String description, int status, BigDecimal price, List<Files> files);
}
