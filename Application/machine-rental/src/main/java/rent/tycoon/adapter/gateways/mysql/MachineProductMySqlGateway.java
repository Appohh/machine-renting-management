package rent.tycoon.adapter.gateways.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.converter.CreateMachineConverter;
import rent.tycoon.adapter.gateways.mapper.ProductJpaMapper;
import rent.tycoon.adapter.repositories.IMachineRepository;
import rent.tycoon.business.boundaries.output.register.IMachineProductRegisterGateway;
import rent.tycoon.domain.IProduct;

@Repository
public class MachineProductMySqlGateway implements IMachineProductRegisterGateway {
    private final IMachineRepository repository;

    @Autowired
    public MachineProductMySqlGateway(IMachineRepository repository){
    this.repository = repository;
    }
    public long save(IProduct iProduct) {
        ProductJpaMapper productJpaMapper = CreateMachineConverter.toMachineJpaMapper(iProduct);
        productJpaMapper.getFiles().forEach(files -> files.setProduct(productJpaMapper));
        return repository.save(productJpaMapper).getId();
    }
    @Override
    public boolean existsById(String id) {return repository.existsById(id);}
    @Override
    public boolean existsByName(String name){
        return repository.existsByName(name);
    }
}
