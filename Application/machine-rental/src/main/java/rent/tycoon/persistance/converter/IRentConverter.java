package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Rent2;
import rent.tycoon.persistance.databases.entity.RentJPAmapper2;

public interface IRentConverter {
    RentJPAmapper2 toRentJpaEntity(Rent2 rent);
    Rent2 toRent(RentJPAmapper2 rentJPAmapper2);
}
