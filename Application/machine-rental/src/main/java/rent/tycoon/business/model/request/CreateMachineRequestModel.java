package rent.tycoon.business.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class CreateMachineRequestModel {
    private String name;
    private String description;
    private int status;
    private BigDecimal price;
    private List<MultipartFile> files;
}
