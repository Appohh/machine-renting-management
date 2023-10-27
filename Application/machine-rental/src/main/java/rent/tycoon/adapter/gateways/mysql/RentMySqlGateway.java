package rent.tycoon.adapter.gateways.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.adapter.repositories.IRentRepository;
import rent.tycoon.business.boundaries.output.register.IRentRegisterGateway;
import rent.tycoon.domain.IRent;



@Repository
public class RentMySqlGateway implements IRentRegisterGateway {
    private final IRentRepository repository;

    @Autowired
    public RentMySqlGateway(IRentRepository repository) {this.repository = repository;}

    public long save(IRent rent){
        // TODO document why this method is empty
        return 1;
    }

    @Override
    public boolean existsByProductId(int productId){
        // TODO document why this method is empty
        return true;
    }
}
