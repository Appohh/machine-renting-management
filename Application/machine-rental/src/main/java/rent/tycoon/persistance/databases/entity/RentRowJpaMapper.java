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
    private long rent_id;
    private long product_id;
    private Date startDate;
    private Date endDate;
    @Timestamp
    private Date timestamp;







}
