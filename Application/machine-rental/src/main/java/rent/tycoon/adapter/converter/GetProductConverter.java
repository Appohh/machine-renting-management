package rent.tycoon.adapter.converter;


import lombok.AllArgsConstructor;
import rent.tycoon.adapter.gateways.mapper.AccessoryJpaMapper;
import rent.tycoon.adapter.gateways.mapper.FilesJpaMapper;
import rent.tycoon.adapter.gateways.mapper.MachineJpaMapper;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.ArrayList;
import java.util.List;



public class GetProductConverter {
    private GetProductConverter(){}
    public static List<IProduct> toProductJpaMapper(List<ProductJpaMapper> productJpaMappers, IProductFactory factory) {
        List<IProduct> productList = new ArrayList<>();

        for (ProductJpaMapper productJpaMapper : productJpaMappers) {
            IProduct product;
            if (productJpaMapper instanceof MachineJpaMapper machine) {
                product = factory.createMachine(0, machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), mapFiles(machine.getFiles()), machine.getType(),machine.getMachineSpecificField());
                productList.add(product);
            }
            else if (productJpaMapper instanceof AccessoryJpaMapper accessory) {
                product = factory.createAccessory(accessory.getId(), accessory.getName(), accessory.getDescription(), accessory.getStatus(), accessory.getPrice(), mapFiles(accessory.getFiles()), accessory.getType(), accessory.getAccessorySpecificField());
                productList.add(product);
            }
        }

        return productList;
    }


    private static List<Files> mapFiles(List<FilesJpaMapper> files) {
        List<Files> newFiles = new ArrayList<>();
        if (files != null) {
            for (FilesJpaMapper Jpa : files) {
                newFiles.add(new Files(Jpa.getFileUrl(), Jpa.getType()));
            }
        }
        return newFiles;
    }
}