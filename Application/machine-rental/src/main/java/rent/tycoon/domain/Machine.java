package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class Machine implements IProduct {
    private long id;
    private String name;
    private String description;
    private int status;
    private BigDecimal price;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription(){
        return description;
    }
    @Override
    public int getStatus(){
        return status;
    }
    @Override
    public BigDecimal getPrice(){return price;}
}

