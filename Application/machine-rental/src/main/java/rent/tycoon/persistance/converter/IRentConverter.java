package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Rent;
import rent.tycoon.domain.RentRow;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.List;
import java.util.Optional;

public interface IRentConverter {
    RentJpaMapper toRentJpaEntity(Rent rent);

    RentRowJpaMapper toRentRowJpaEntity(RentRow rentRow);

    Optional<Rent> toSingleOptionalRent(Optional<RentJpaMapper> rentJpaMapper);

    List<Rent> toListOfRents(List<RentJpaMapper> rentJpaMappers);

    List<RentRow> toListOfRentRows(List<RentRowJpaMapper> rentRowJpaMappers);
}
