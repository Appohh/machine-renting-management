package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rent")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentJpaMapper {
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
    @OneToMany(mappedBy = "rent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentRowJpaMapper> rentRow;


}
