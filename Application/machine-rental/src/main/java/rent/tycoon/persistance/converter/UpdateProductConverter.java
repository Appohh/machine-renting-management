package rent.tycoon.persistance.converter;

import rent.tycoon.persistance.databases.entity.AccessoryJpaMapper;
import rent.tycoon.persistance.databases.entity.FilesJpaMapper;
import rent.tycoon.persistance.databases.entity.MachineJpaMapper;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.List;


public class UpdateProductConverter {
    private UpdateProductConverter() {
    }

    public static IProduct toProduct(ProductJpaMapper productJpaMapper, IProductFactory factory) {
        IProduct product;

        if (productJpaMapper instanceof MachineJpaMapper machine) {
            product = factory.createMachine(machine.getId(), machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), FilesConverter.mapToFiles(machine.getFiles()), machine.getType(), machine.getMachineSpecificField());
            return product;
        } else if (productJpaMapper instanceof AccessoryJpaMapper accessory) {
            product = factory.createAccessory(accessory.getId(), accessory.getName(), accessory.getDescription(), accessory.getStatus(), accessory.getPrice(), FilesConverter.mapToFiles(accessory.getFiles()), accessory.getType(), accessory.getAccessorySpecificField());
            return product;
        }
        throw new IllegalArgumentException("Theatre not found");

    }


    public static ProductJpaMapper UpdateExistingProduct(ProductJpaMapper existingProduct) {
        ProductJpaMapper updatedProduct = new ProductJpaMapper();

        if (existingProduct != null) {
            updatedProduct.setName(existingProduct.getName());
            updatedProduct.setDescription(existingProduct.getDescription());
            updatedProduct.setStatus(existingProduct.getStatus());
            updatedProduct.setPrice(existingProduct.getPrice());
            updatedProduct.setType(existingProduct.getType());
            List<FilesJpaMapper> updatedFiles = FilesConverter.updateFiles(existingProduct.getFiles());
            updatedProduct.getFiles().addAll(updatedFiles);
        }
        return updatedProduct;
    }

}
