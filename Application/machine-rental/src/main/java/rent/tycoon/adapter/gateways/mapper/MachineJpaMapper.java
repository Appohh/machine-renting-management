package rent.tycoon.adapter.gateways.mapper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Machine")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MachineJpaMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int status;
    private BigDecimal price;
}
