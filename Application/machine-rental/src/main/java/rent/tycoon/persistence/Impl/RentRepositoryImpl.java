package rent.tycoon.persistence.Impl;

import org.springframework.stereotype.Repository;
import rent.tycoon.business.interfaces.RentRepository;
import rent.tycoon.domain.CreateRent;


@Repository
public class RentRepositoryImpl implements RentRepository {

    public CreateRent saveRent(CreateRent createRent){
        return createRent;
    }
}
