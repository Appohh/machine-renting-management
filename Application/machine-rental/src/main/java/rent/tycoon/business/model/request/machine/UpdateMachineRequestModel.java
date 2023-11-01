package rent.tycoon.business.model.request.machine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.model.request.product.UpdateProductRequestModel;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@Getter
public class UpdateMachineRequestModel extends UpdateProductRequestModel {
    private String machineSpecificField;
    public UpdateMachineRequestModel (long Id,String name, String description, int status, BigDecimal price, List<MultipartFile> files, String type, String machineSpecificField) {
        super(Id,name, description, status, price, files, type);
        this.machineSpecificField = machineSpecificField;
    }
}
