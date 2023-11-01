package rent.tycoon.business.model.request.accessory;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.model.request.product.CreateProductRequestModel;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Getter
public class CreateAccessoryRequestModel extends CreateProductRequestModel {
    private String accessorySpecificField;

    public CreateAccessoryRequestModel(String name, String description, int status, BigDecimal price, List<MultipartFile> files, String type, String accessorySpecificField) {
        super(name, description, status, price, files, type);
        this.accessorySpecificField = accessorySpecificField;
    }
}
