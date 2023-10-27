package rent.tycoon.domain.factory;

import org.springframework.context.annotation.Configuration;

import rent.tycoon.domain.Machine;
import java.math.BigDecimal;
@Configuration
public class MachineProductFactory implements IMachineProductFactory{
    @Override
    public Machine create(long id, String name, String description, int status, BigDecimal price){
        return new Machine(id,name,description,status,price);
    }
}
