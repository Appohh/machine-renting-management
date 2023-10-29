package rent.tycoon.adapter.gateways.mapper;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Rent")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentJpaMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long productId;
    private long customerId;
    private Date start;
    private Date end;
    private String address;
    private String city;
    @Timestamp
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
}
