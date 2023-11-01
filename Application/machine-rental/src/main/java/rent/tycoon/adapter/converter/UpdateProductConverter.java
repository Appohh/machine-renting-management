package rent.tycoon.adapter.converter;

import rent.tycoon.adapter.gateways.mapper.AccessoryJpaMapper;
import rent.tycoon.adapter.gateways.mapper.FilesJpaMapper;
import rent.tycoon.adapter.gateways.mapper.MachineJpaMapper;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;
import rent.tycoon.domain.Accessory;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Machine;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.ArrayList;
import java.util.List;

public class UpdateProductConverter {
    private UpdateProductConverter(){}
    public static IProduct toProductJpaMapper(ProductJpaMapper productJpaMapper, IProductFactory factory) {
            IProduct product;

            if (productJpaMapper instanceof MachineJpaMapper machine) {
                product = factory.createMachine(machine.getId(), machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), mapFiles(machine.getFiles()), machine.getType(),machine.getMachineSpecificField());
                return product;
            }
            else if (productJpaMapper instanceof AccessoryJpaMapper accessory) {
                product = factory.createAccessory(accessory.getId(), accessory.getName(), accessory.getDescription(), accessory.getStatus(), accessory.getPrice(), mapFiles(accessory.getFiles()), accessory.getType(), accessory.getAccessorySpecificField());
                return product;
            }
        throw new IllegalArgumentException("Theatre not found");

    }


    private static List<Files> mapFiles(List<FilesJpaMapper> fileUrl) {
        List<Files> files = new ArrayList<>();
        if (fileUrl != null) {
            for (FilesJpaMapper file : fileUrl) {
                files.add(createFilesJpaMapper(file.getFileUrl(), file.getType()));
            }
        }
        return files;
    }

    private static Files createFilesJpaMapper(String fileUrl, String type) {
        return Files.builder()
                .fileUrl(fileUrl)
                .type(type)
                .build();
    }
}
