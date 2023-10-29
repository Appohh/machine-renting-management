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
    //Hier nog een list van maken. Maakt mogelijk dat een user meerdere producten kan renten tegelijkertijd
    private long productId;
    private long customerId;
    private Date start;
    private Date end;
    private String address;
    private String city;
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;

    @Override
    public long getId(){
        return id;
    }
    @Override
    public long getProductId(){return productId;}
    @Override
    public long getCustomerId(){
        return customerId;
    }
    @Override
    public Date getStart(){
        return start;
    }
    @Override
    public Date getEnd(){
        return end;
    }
    @Override
    public String getAddress(){
        return address;
    }
    @Override
    public String getCity(){
        return city;
    }
    @Override
    public Date getTimestamp(){
        return timestamp;
    }
    @Override
    public BigDecimal getTotal(){
        return total;
    }
    @Override
    public BigDecimal getDiscount(){
        return discount;
    }
    @Override
    public int getPaid(){
        return paid;
    }



}
