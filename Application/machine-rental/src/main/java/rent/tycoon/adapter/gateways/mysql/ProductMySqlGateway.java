package rent.tycoon.adapter.gateways.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.adapter.converter.CreateProductConverter;
import rent.tycoon.adapter.converter.GetProductConverter;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;
import rent.tycoon.adapter.repositories.IProductRepository;
import rent.tycoon.business.boundaries.output.IProductRegisterGateway;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.List;

@Repository
public class ProductMySqlGateway implements IProductRegisterGateway {
    private final IProductRepository repository;
    private final IProductFactory factory;

    @Autowired
    public ProductMySqlGateway(IProductRepository repository, IProductFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }
    @Transactional
    public long save(IProduct iProduct) {
        ProductJpaMapper productJpaMapper = CreateProductConverter.toProductJpaMapper(iProduct);
        productJpaMapper.getFiles().forEach(files -> files.setProduct(productJpaMapper));
        return repository.save(productJpaMapper).getId();
    }
    @Override
    public boolean existsById(String id) {return repository.existsById(id);}
    @Override
    public boolean existsByName(String name){
        return repository.existsByName(name);
    }
    @Override
    public List<IProduct> findProductByName(String name){
        List <ProductJpaMapper> product = repository.findProductByName(name);
        return GetProductConverter.toProductJpaMapper(product, factory);
    }
}
