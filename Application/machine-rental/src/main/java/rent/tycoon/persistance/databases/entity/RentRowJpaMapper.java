package rent.tycoon.persistance.databases.entity;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "rentrow")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentRowJpaMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private long id;
    private long rentId;
    private long productId;
    private Date startDate;
    private Date endDate;
    @Timestamp
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name = "rent_id")
    private RentJpaMapper product;







}
