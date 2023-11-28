package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "machine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MachineJpaMapper extends ProductJpaMapper {
    private String machineSpecificField;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "machine_category",
            joinColumns = { @JoinColumn(name = "machine_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    private Set<CategoryJpaMapper> categories = new HashSet<>();

    public MachineJpaMapper(long id, String name, String description, int status, BigDecimal price, List<FilesJpaMapper> files, String machineSpecificField, Set<CategoryJpaMapper> categories) {
        super(id, name, description, status, price, files);
        this.machineSpecificField = machineSpecificField;
        this.categories = categories;
    }
}
