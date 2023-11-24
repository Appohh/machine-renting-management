package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Accessory;
import rent.tycoon.domain.Machine;
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
            product = factory.createMachine(machine.getId(), machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), FilesConverter.mapToFiles(machine.getFiles()), machine.getMachineSpecificField(), m);
            return product;
        } else if (productJpaMapper instanceof AccessoryJpaMapper accessory) {
            product = factory.createAccessory(accessory.getId(), accessory.getName(), accessory.getDescription(), accessory.getStatus(), accessory.getPrice(), FilesConverter.mapToFiles(accessory.getFiles()), accessory.getAccessorySpecificField());
            return product;
        }
        throw new IllegalArgumentException("Theatre not found");

    }


    public static ProductJpaMapper updateExistingProduct(IProduct newProduct, ProductJpaMapper oldProduct) {
        if (newProduct != null) {
            oldProduct.setName(newProduct.getName());
            oldProduct.setDescription(newProduct.getDescription());
            oldProduct.setStatus(newProduct.getStatus());
            oldProduct.setPrice(newProduct.getPrice());
            List<FilesJpaMapper> updatedFiles = FilesConverter.mapToJpaFiles(newProduct.getFiles());
            oldProduct.getFiles().clear();
            oldProduct.getFiles().addAll(updatedFiles);
        }
        if (newProduct instanceof Machine) {
            MachineJpaMapper machine = (MachineJpaMapper) oldProduct;
            machine.setMachineSpecificField(((Machine) newProduct).getMachineSpecificField());
        }
        else if (newProduct instanceof Accessory) {
            AccessoryJpaMapper accessory = (AccessoryJpaMapper) oldProduct;
            accessory.setAccessorySpecificField(((Accessory) newProduct).getAccessorySpecificField());
        }


        return oldProduct;
    }

}
