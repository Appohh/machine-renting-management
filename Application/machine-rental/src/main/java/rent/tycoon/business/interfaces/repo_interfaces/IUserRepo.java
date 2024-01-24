package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.Customer;

import java.util.Date;

public interface IUserRepo {
    Customer updateUserDetails(long id, String firstName, String lastName, String address, String city, String email, int phone);
    Customer getUserById(long userId);
}
