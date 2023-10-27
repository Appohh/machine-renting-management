package rent.tycoon.domain;


import java.math.BigDecimal;

public interface IProduct {
    long getId();
    String getName();
    String getDescription();
    int getStatus();
    BigDecimal getPrice();

}
