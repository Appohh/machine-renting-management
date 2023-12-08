package rent.tycoon.persistance.converter;

import org.springframework.stereotype.Service;
import rent.tycoon.domain.Accessory;
import rent.tycoon.domain.Files;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Machine;
import rent.tycoon.domain.factory.IProductFactory;
import rent.tycoon.persistance.databases.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static rent.tycoon.persistance.converter.CategoryConverter.mapCategoryJpaMappers;

@Service
public class ProductConverterImpl implements ProductConverter {
    @Override
    public IProduct toProduct(ProductJpaMapper productJpaMapper, IProductFactory factory) {
        IProduct product;

        if (productJpaMapper instanceof MachineJpaMapper machine) {
            product = factory.createMachine(machine.getId(), machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), FilesConverter.mapToFiles(machine.getFiles()), machine.getMachineSpecificField(), (mapCategoryJpaMappers(machine.getCategories())));
            return product;
        } else if (productJpaMapper instanceof AccessoryJpaMapper accessory) {
            product = factory.createAccessory(accessory.getId(), accessory.getName(), accessory.getDescription(), accessory.getStatus(), accessory.getPrice(), FilesConverter.mapToFiles(accessory.getFiles()), accessory.getAccessorySpecificField());
            return product;
        }
        throw new IllegalArgumentException("Product not found");
    }

    @Override
    public ProductJpaMapper updateExistingProduct(IProduct newProduct, ProductJpaMapper oldProduct, Set<CategoryJpaMapper> categoryJpaMappers) {
        if (newProduct != null) {
            oldProduct.setName(newProduct.getName());
            oldProduct.setDescription(newProduct.getDescription());
            oldProduct.setStatus(newProduct.getStatus());
            oldProduct.setPrice(newProduct.getPrice());
            List<FilesJpaMapper> updatedFiles = FilesConverter.mapToJpaFiles(newProduct.getFiles());
            oldProduct.getFiles().clear();
            oldProduct.getFiles().addAll(updatedFiles);
        }
        if (newProduct instanceof Machine machine) {
            MachineJpaMapper jpaMachine = (MachineJpaMapper) oldProduct;
            jpaMachine.setMachineSpecificField(machine.getMachineSpecificField());
            jpaMachine.setCategories(categoryJpaMappers);

        }
        else if (newProduct instanceof Accessory accessory) {
            AccessoryJpaMapper jpaAccessory = (AccessoryJpaMapper) oldProduct;
            jpaAccessory.setAccessorySpecificField(accessory.getAccessorySpecificField());
        }


        return oldProduct;
    }

    @Override
    public List<IProduct> toListOfProduct(List<ProductJpaMapper> productJpaMappers, IProductFactory factory) {
        List<IProduct> productList = new ArrayList<>();

        for (ProductJpaMapper productJpaMapper : productJpaMappers) {
            IProduct product;
            if (productJpaMapper instanceof MachineJpaMapper machine) {
                product = factory.createMachine(machine.getId(), machine.getName(), machine.getDescription(), machine.getStatus(), machine.getPrice(), mapFiles(machine.getFiles()),machine.getMachineSpecificField(), (mapCategoryJpaMappers(machine.getCategories())));
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
