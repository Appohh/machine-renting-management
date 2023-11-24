package rent.tycoon.persistance.converter;


import rent.tycoon.persistance.databases.entity.AccessoryJpaMapper;
import rent.tycoon.persistance.databases.entity.FilesJpaMapper;
import rent.tycoon.persistance.databases.entity.MachineJpaMapper;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;
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
                product = factory.createMachine(machine.getId(), machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), mapFiles(machine.getFiles()),machine.getMachineSpecificField(), m);
                productList.add(product);
            }
            else if (productJpaMapper instanceof AccessoryJpaMapper accessory) {
                product = factory.createAccessory(accessory.getId(), accessory.getName(), accessory.getDescription(), accessory.getStatus(), accessory.getPrice(), mapFiles(accessory.getFiles()), accessory.getAccessorySpecificField());
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