package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Machine implements IProduct {
    private long id;
    private String name;
    private String description;
    private int status;
    private BigDecimal price;
    private List <Files> files;
    private String machineSpecificField;
    private Set<Integer> machineCategory;


    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription(){return description;}
    @Override
    public int getStatus(){
        return status;
    }
    @Override
    public BigDecimal getPrice(){return price;}
    @Override
    public List<Files> getFiles(){return files;}
}

