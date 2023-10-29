package rent.tycoon.domain.factory;

import org.springframework.context.annotation.Configuration;

import rent.tycoon.domain.Files;
import rent.tycoon.domain.Machine;
import java.math.BigDecimal;
import java.util.List;

@Configuration
public class MachineProductFactory implements IMachineProductFactory{
    @Override
    public Machine create(long id, String name, String description, int status, BigDecimal price, List<Files> files){
        return new Machine(id,name,description,status,price, files);
    }
}
