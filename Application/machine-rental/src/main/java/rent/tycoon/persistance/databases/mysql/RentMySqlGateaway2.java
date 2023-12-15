package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo2;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.Rent2;
import rent.tycoon.domain.factory.IProductFactory;
import rent.tycoon.persistance.converter.IRentConverter;
import rent.tycoon.persistance.converter.ProductConverter;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;
import rent.tycoon.persistance.repositories.IRentRepository2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RentMySqlGateaway2 implements IRentRepo2{
    private final IRentRepository2 repository;
    private final IRentConverter rentConverter;
    private final IProductFactory factory;
    private final ProductConverter productConverter;

    @Autowired
    public RentMySqlGateaway2(IRentRepository2 repository, IRentConverter rentConverter, ProductConverter productConverter, IProductFactory factory) {
        this.repository = repository;
        this.rentConverter = rentConverter;
        this.productConverter = productConverter;
        this.factory = factory;
    }

    @Transactional
    public long save(Rent2 rent){
        RentJPAmapper2 rentJpaMapper = rentConverter.toRentJpaEntity(rent);

        return repository.save(rentJpaMapper).getId();
    }

    public Map<Rent2, IProduct> getRentsAndProductsByCustomerId(long customerId) {
        List<Object[]> rentAndProductObjects = repository.findRentAndProductByCustomerId(customerId);
        Map<Rent2, IProduct> rentProductMap = new HashMap<>();

        for (Object[] objects : rentAndProductObjects) {
            RentJPAmapper2 rentJPAmapper2 = (RentJPAmapper2) objects[0];
            ProductJpaMapper productJpaMapper = (ProductJpaMapper) objects[1];

            Rent2 rent = rentConverter.toRent(rentJPAmapper2);
            IProduct product = productConverter.toProduct(productJpaMapper, factory);

            rentProductMap.put(rent, product);
        }

        return rentProductMap;
    }
}
