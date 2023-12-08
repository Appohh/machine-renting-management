package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "rent2")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentJPAmapper2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private long customerId;
    private String address;
    private String city;
    @Timestamp
    private Date timestamp;
    private BigDecimal total;
    private BigDecimal discount;
    private int paid;
    private long productId;
    private Date startDate;
    private Date endDate;
}
