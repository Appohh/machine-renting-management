    package rent.tycoon.business.model.request.machine;



    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.springframework.web.multipart.MultipartFile;
    import rent.tycoon.business.model.request.accessory.CreateAccessoryRequestModel;
    import rent.tycoon.business.model.request.product.CreateProductRequestModel;
    import rent.tycoon.domain.Category;

    import java.math.BigDecimal;
    import java.util.List;
    import java.util.Set;

    @NoArgsConstructor
    @Getter
    public class CreateMachineRequestModel extends CreateProductRequestModel {
        private String machineSpecificField;
        private Set<Integer> category;

        public CreateMachineRequestModel(String name, String description, int status, BigDecimal price, List<MultipartFile> files, String machineSpecificField, Set<Integer> category) {
            super(name, description, status, price, files);
            this.machineSpecificField = machineSpecificField;
            this.category = category;
        }
    }
