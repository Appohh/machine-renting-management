package rent.tycoon.persistance.converter;

import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;
import rent.tycoon.persistance.databases.entity.CategoryJpaMapper;
import rent.tycoon.persistance.databases.entity.MachineJpaMapper;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;

import java.util.List;
import java.util.Set;

public interface ProductConverter {
    IProduct toProduct(ProductJpaMapper productJpaMapper, IProductFactory factory);

    ProductJpaMapper updateExistingProduct(IProduct newProduct, ProductJpaMapper oldProduct, Set<CategoryJpaMapper> categoryJpaMappers);

    List<IProduct> toListOfProduct(List<ProductJpaMapper> productJpaMappers, IProductFactory factory);
    List<IProduct> convertMachine(List<MachineJpaMapper> machineJPAmappers);
}
