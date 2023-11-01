package rent.tycoon.persistance.gateways.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.persistance.converter.CreateProductConverter;
import rent.tycoon.persistance.converter.GetProductConverter;
import rent.tycoon.persistance.converter.UpdateProductConverter;
import rent.tycoon.persistance.gateways.mapper.FilesJpaMapper;
import rent.tycoon.persistance.gateways.mapper.ProductJpaMapper;
import rent.tycoon.persistance.repositories.IProductRepository;
import rent.tycoon.business.interfaces.repo_interfaces.IProductRegisterGateway;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;

import java.util.List;

import static rent.tycoon.persistance.converter.CreateProductConverter.mapFiles;

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



    @Transactional
    public IProduct update(IProduct updatedProduct) {
        long productId = updatedProduct.getId();

        if (!existsById(String.valueOf(productId))) {
            throw new RuntimeException("Product with Id: " + productId + " doesnt exist");
        }

        ProductJpaMapper existingProduct = repository.findById(String.valueOf(productId)).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setStatus(updatedProduct.getStatus());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setType(updatedProduct.getType());
            List<FilesJpaMapper> updatedFiles = mapFiles(updatedProduct.getFileUrl());
            existingProduct.getFiles().clear();
            existingProduct.getFiles().addAll(updatedFiles);

            ProductJpaMapper savedProduct = repository.save(existingProduct);
            return UpdateProductConverter.toProductJpaMapper(savedProduct, factory);

        } else {
            throw new RuntimeException("No se pudo encontrar el producto con ID " + productId);
        }
    }

}
