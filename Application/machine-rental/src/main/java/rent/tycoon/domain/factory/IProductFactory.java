package rent.tycoon.domain.factory;

import rent.tycoon.domain.Category;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface IProductFactory {
    IProduct createMachine(long id, String name, String description, int status, BigDecimal price, List<Files> files, String machineSpecificField, Set<Integer> category);

    IProduct createAccessory(long id, String name, String description, int status, BigDecimal price, List<Files> files, String accessorySpecificField);
}
