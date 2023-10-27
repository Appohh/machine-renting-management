package rent.tycoon.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Rent implements IRent {
    private long id;
    private int productId;
    private int customerId;
    private Date start;
    private Date end;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
    private Image image;

    @Override
    public long id(){
        return id;
    }
    @Override
    public int productId(){
        return productId;
    }
    @Override
    public int customerId(){
        return customerId;
    }
    @Override
    public Date start(){
        return start;
    }
    @Override
    public Date end(){
        return end;
    }
    @Override
    public String address(){
        return address;
    }
    @Override
    public String city(){
        return city;
    }
    @Override
    public Date timestamp(){
        return timestamp;
    }
    @Override
    public BigDecimal total(){
        return total;
    }
    @Override
    public BigDecimal discount(){
        return discount;
    }
    @Override
    public int paid(){
        return paid;
    }
    @Override
    public Image image(){
        return image;
    }


}
