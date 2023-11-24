package rent.tycoon.persistance.converter;

import rent.tycoon.persistance.databases.entity.*;
import rent.tycoon.domain.Accessory;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Machine;

import java.util.ArrayList;
import java.util.List;

public class CreateProductConverter {

    private CreateProductConverter(){}

    public static ProductJpaMapper toProductJpaMapper(IProduct iProduct) {
        List<FilesJpaMapper> filesJpaMappers = FilesConverter.mapToJpaFiles(iProduct.getFiles());
        if (iProduct instanceof Machine machine) {
            return new MachineJpaMapper(
                    0,
                    machine.getName(),
                    machine.getDescription(),
                    machine.getStatus(),
                    machine.getPrice(),
                    filesJpaMappers,
                    machine.getMachineSpecificField()
            );

        } else if (iProduct instanceof Accessory accessory) {
            return new AccessoryJpaMapper(
                    0,
                    accessory.getName(),
                    accessory.getDescription(),
                    accessory.getStatus(),
                    accessory.getPrice(),
                    filesJpaMappers,
                    accessory.getAccessorySpecificField()
            );
        } else {
            throw new IllegalArgumentException("Invalid product type: " + iProduct.getClass().getSimpleName());
        }
    }
}
