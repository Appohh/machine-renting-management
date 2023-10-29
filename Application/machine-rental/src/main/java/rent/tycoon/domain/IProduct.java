package rent.tycoon.domain;


import java.math.BigDecimal;
import java.util.List;

public interface IProduct {
    long getId();
    String getName();
    String getDescription();
    int getStatus();
    BigDecimal getPrice();
    List<Files> getFileUrl();

}
