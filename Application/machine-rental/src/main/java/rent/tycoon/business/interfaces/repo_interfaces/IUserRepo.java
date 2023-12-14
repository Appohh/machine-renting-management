package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.Customer;

import java.util.Date;

public interface IUserRepo {
    Customer updateUserDetails(Long id, String firstName, String lastName, Date birthDate, String address, String city, String email, int phone);
}
