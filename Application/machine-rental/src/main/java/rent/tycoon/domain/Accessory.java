package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class Accessory implements IProduct{
    private long id;
    private String name;
    private String description;
    private int status;
    private BigDecimal price;
    private List<Files> files;
    private String type;
    private String accessorySpecificField;



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
    public String getType(){return type;}
    @Override
    public List<Files> getFiles(){return files;}
}
