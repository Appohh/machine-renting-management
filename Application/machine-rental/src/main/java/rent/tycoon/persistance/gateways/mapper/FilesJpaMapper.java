package rent.tycoon.persistance.gateways.mapper;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Files")
public class FilesJpaMapper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "file_url")
    private String fileUrl;
    @Column (name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductJpaMapper product;
}