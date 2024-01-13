package rent.tycoon.persistance.databases.entity;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.RentRow;

import java.util.Date;

@Entity
@Table(name = "rentrow")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentRowJpaMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private long id;
    private long productId;
    private Date startDate;
    private Date endDate;
    private long rentId;
}
