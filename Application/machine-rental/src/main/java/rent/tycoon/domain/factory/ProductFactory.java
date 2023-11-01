package rent.tycoon.domain.factory;

import org.springframework.context.annotation.Configuration;

import rent.tycoon.domain.Accessory;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.Machine;
import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductFactory implements IProductFactory {
    @Override
    public Machine createMachine(long id, String name, String description, int status, BigDecimal price, List<Files> files, String type, String machineSpecificField ){
        return new Machine(id,name,description,status,price, files, type, machineSpecificField);
    }

    @Override
    public Accessory createAccessory(long id, String name, String description, int status, BigDecimal price, List<Files> files, String type, String accessorySpecificField) {
        return new Accessory(id, name, description, status, price, files, type, accessorySpecificField);
    }
}
