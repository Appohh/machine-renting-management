package rent.tycoon.business.model.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateProductRequestModel {
    private String name;
    private String description;
    private int status;
    private BigDecimal price;
    private List<MultipartFile> files;
    private String type;
}
