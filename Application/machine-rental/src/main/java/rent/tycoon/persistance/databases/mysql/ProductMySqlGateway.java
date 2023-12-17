package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.domain.Category;
import rent.tycoon.domain.Machine;
import rent.tycoon.persistance.converter.CreateProductConverter;
import rent.tycoon.persistance.converter.ProductConverter;
import rent.tycoon.persistance.databases.entity.AccessoryJpaMapper;
import rent.tycoon.persistance.databases.entity.CategoryJpaMapper;
import rent.tycoon.persistance.databases.entity.MachineJpaMapper;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;
import rent.tycoon.business.interfaces.repo_interfaces.IProductRepo;
import rent.tycoon.domain.IProduct;
import rent.tycoon.domain.factory.IProductFactory;
import rent.tycoon.persistance.repositories.ICategoryRepository;
import rent.tycoon.persistance.repositories.IProductRepository;

import java.util.*;

@Repository
public class ProductMySqlGateway implements IProductRepo {
    private final IProductRepository repository;
    private final IProductFactory factory;
    private final ICategoryRepository categoryRepository;
    private final ProductConverter productConverter;
    @Autowired
    public ProductMySqlGateway(IProductRepository repository, IProductFactory factory, ICategoryRepository categoryRepository, ProductConverter productConverter) {
        this.repository = repository;
        this.factory = factory;
        this.categoryRepository = categoryRepository;
        this.productConverter = productConverter;
    }
    @Transactional
    public long save(IProduct iProduct) {
        Set<CategoryJpaMapper> categoryJpaMapper = findCategoriesByIds(iProduct);
        ProductJpaMapper productJpaMapper = CreateProductConverter.toProductJpaMapper(iProduct, categoryJpaMapper);
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
        return productConverter.toListOfProduct(product, factory);
    }



    @Transactional
    public IProduct update(IProduct newProduct) {
        long productId = newProduct.getId();

        if (!existsById(String.valueOf(productId))) {
            throw new RuntimeException("Product with Id: " + productId + " doesnt exist");
        }


        Set<CategoryJpaMapper> categoryJpaMapper = findCategoriesByIds(newProduct);
        ProductJpaMapper oldProduct = repository.findById(String.valueOf(productId)).orElse(null);
        ProductJpaMapper savedProduct = productConverter.updateExistingProduct(newProduct, oldProduct, categoryJpaMapper);

        ProductJpaMapper product = null;
        if (savedProduct != null) {
            product = repository.save(savedProduct);
        }
        return productConverter.toProduct(product, factory);
    }

    public List <IProduct> getMachineByCategory (Integer categoryId){
        List <ProductJpaMapper> product =  repository.findByCategoryId(categoryId);
        return productConverter.toListOfProduct(product, factory);
    }

    @Override
    public IProduct getProductById(Long id){
        ProductJpaMapper jpaProducts = repository.findByProductId(id);
        return productConverter.toProduct(jpaProducts, factory);
    }

    private Set<CategoryJpaMapper> findCategoriesByIds(IProduct iProduct) {
        Set<CategoryJpaMapper> categoryJpaMappers = new HashSet<>();

        if (iProduct instanceof Machine machine) {
            for (Integer id : machine.getMachineCategory()) {
                categoryRepository.findById(id)
                        .ifPresent(categoryJpaMappers::add);
            }
        }

        return categoryJpaMappers;
    }

    @Override
    public List<IProduct> getAllProducts(){
        List <ProductJpaMapper> jpaProducts = repository.findAll();
        return productConverter.toListOfProduct(jpaProducts, factory);
    }
    @Transactional
    public List<IProduct> filterProduct(String name, int price, long category) {
        List<MachineJpaMapper> machineJPAmappers = repository.findMachinesByFilter(name, price, category);
        return productConverter.convertMachine(machineJPAmappers);
    }

    //    public List<Category> findCategoryById(List<Integer> categoryIds) {
//        return categoryIds.stream()
//                .map(categoryRepository::findById)
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .map(CategoryConverter::toCategory)
//                .filter(Objects::nonNull)
//                .toList();
//    }
}
