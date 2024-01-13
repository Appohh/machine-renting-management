package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.Rent;
import rent.tycoon.domain.RentRow;

import java.util.List;
import java.util.Optional;

public interface IRentRepo extends IRentExistsGateway{
     long save (Rent rent);
     long saveRentRow(RentRow rentRow);
     Optional<Rent> findByRentId(long rentId);
     List<Rent> getAllRents(long customerId);
     List<RentRow>getAllRentRows(long rentId);

}
