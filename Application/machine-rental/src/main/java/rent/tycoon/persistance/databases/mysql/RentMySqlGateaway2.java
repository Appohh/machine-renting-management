package rent.tycoon.persistance.databases.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rent.tycoon.business.interfaces.repo_interfaces.IRentRepo2;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.Rent2;
import rent.tycoon.persistance.converter.RentConverter;
import rent.tycoon.persistance.converter.RentConverter2;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.repositories.IRentRepository;
import rent.tycoon.persistance.repositories.IRentRepository2;

@Repository
public class RentMySqlGateaway2 implements IRentRepo2{
    private final IRentRepository2 repository;

    @Autowired
    public RentMySqlGateaway2(IRentRepository2 repository) {this.repository = repository;}

    @Transactional
    public long save(Rent2 rent){
        RentJPAmapper2 rentJpaMapper = RentConverter2.toRentJpaEntity(rent);

        return repository.save(rentJpaMapper).getId();
    }
}
