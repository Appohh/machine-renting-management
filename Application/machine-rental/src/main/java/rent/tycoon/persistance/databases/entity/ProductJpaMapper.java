package rent.tycoon.persistance.databases.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductJpaMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int status;
    private BigDecimal price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilesJpaMapper> files;
}
