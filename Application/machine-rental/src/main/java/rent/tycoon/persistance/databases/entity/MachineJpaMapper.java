package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "machine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MachineJpaMapper extends ProductJpaMapper {
    private String machineSpecificField;


    public MachineJpaMapper(long id, String name, String description, int status, BigDecimal price, List<FilesJpaMapper> files, String type, String machineSpecificField) {
        super(id, name, description, status, price, files, type);
        this.machineSpecificField = machineSpecificField;
    }
}
