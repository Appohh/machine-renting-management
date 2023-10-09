package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
@Builder
public class Product {
    private int id;
    private String name;
    private int status;
    private BigDecimal price;
    private String description;
}
