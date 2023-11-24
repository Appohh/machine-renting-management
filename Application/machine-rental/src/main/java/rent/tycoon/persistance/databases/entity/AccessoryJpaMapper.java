package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "accessory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccessoryJpaMapper extends ProductJpaMapper {
    private String accessorySpecificField;

    public AccessoryJpaMapper(long id, String name, String description, int status, BigDecimal price, List<FilesJpaMapper> files, String machineSpecificField) {
        super(id, name, description, status, price, files);
        this.accessorySpecificField = machineSpecificField;
    }
}
