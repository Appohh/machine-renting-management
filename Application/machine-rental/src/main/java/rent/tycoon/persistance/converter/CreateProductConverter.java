package rent.tycoon.persistance.converter;

import rent.tycoon.persistance.gateways.mapper.AccessoryJpaMapper;
import rent.tycoon.persistance.gateways.mapper.FilesJpaMapper;
import rent.tycoon.persistance.gateways.mapper.MachineJpaMapper;
import rent.tycoon.persistance.gateways.mapper.ProductJpaMapper;
import rent.tycoon.domain.Accessory;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Machine;

import java.util.ArrayList;
import java.util.List;

public class CreateProductConverter {

    private CreateProductConverter(){}

    public static ProductJpaMapper toProductJpaMapper(IProduct iProduct) {
        List<FilesJpaMapper> filesJpaMappers = mapFiles(iProduct.getFileUrl());
        if (iProduct instanceof Machine machine) {
            return new MachineJpaMapper(
                    0,
                    machine.getName(),
                    machine.getDescription(),
                    machine.getStatus(),
                    machine.getPrice(),
                    filesJpaMappers,
                    machine.getType(),
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
                    accessory.getType(),
                    accessory.getAccessorySpecificField()
            );
        } else {
            throw new IllegalArgumentException("Invalid product type: " + iProduct.getClass().getSimpleName());
        }
    }




        

    public static List<FilesJpaMapper> mapFiles(List<Files> fileUrl) {
        List<FilesJpaMapper> filesJpaMapper = new ArrayList<>();
        if (fileUrl != null) {
            for (Files file : fileUrl) {
                filesJpaMapper.add(createFilesJpaMapper(file.getFileUrl(), file.getType()));
            }
        }
        return filesJpaMapper;
    }

    private static FilesJpaMapper createFilesJpaMapper(String fileUrl, String type) {
        return FilesJpaMapper.builder()
                .fileUrl(fileUrl)
                .type(type)
                .build();
    }
}
