package rent.tycoon.persistence.Impl;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Repository;
import rent.tycoon.business.interfaces.RentRepository;
import rent.tycoon.domain.Rent;

import java.util.ArrayList;
import java.util.List;



@Repository
public class RentRepositoryImpl implements RentRepository {

    private final List<Rent> savedRent;
    private static int NEXT_ID = 1;

    public RentRepositoryImpl() {
        this.savedRent = new ArrayList<>();
    }


    @Observed
    public Rent saveRent(Rent createRent){
        createRent.setId(NEXT_ID);
        setNextId(NEXT_ID);
        this.savedRent.add(createRent);
        return createRent;
    }

    public void setNextId(int id) {
        NEXT_ID++;
    }
}
