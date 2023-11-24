package rent.tycoon.business.model.request.machine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.model.request.product.UpdateProductRequestModel;
import rent.tycoon.domain.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
public class UpdateMachineRequestModel extends UpdateProductRequestModel {
    private String machineSpecificField;
    private Set<Category> category;
    public UpdateMachineRequestModel (long id, String name, String description, int status, BigDecimal price, List<MultipartFile> files, String machineSpecificField, Set<Category> category) {
        super(id, name, description, status, price, files);
        this.machineSpecificField = machineSpecificField;
        this.category = category;
    }
}
