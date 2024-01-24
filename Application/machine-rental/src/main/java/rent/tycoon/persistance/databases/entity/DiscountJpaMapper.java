package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="discount_codes")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountJpaMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String type;
    private int value;
    @Timestamp
    private Date timestamp;
}
