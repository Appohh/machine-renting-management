package rent.tycoon.persistance.databases.mysql;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;
import rent.tycoon.business.interfaces.repo_interfaces.IUserRepo;
import rent.tycoon.domain.Customer;
import rent.tycoon.persistance.converter.CustomerConverter;
import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;
import rent.tycoon.persistance.repositories.IUserRepository;

import java.util.Date;

@Repository
public class UserMySqlGateway implements IUserRepo {

    private IUserRepository userRepository;
    public Customer updateUserDetails(Long id, String firstName, String lastName, Date birthDate, String address, String city, String email, int phone) {
        // Find the user by ID
        UserJpaMapper user = userRepository.findUserById(id);

        if (user!=null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setBirthDate(birthDate);
            user.setAddress(address);
            user.setCity(city);
            user.setEmail(email);
            user.setPhone(phone);

            // Save the updated user
             userRepository.save(user);
            Customer customer =CustomerConverter.CustomerConvert(user);
             return customer;
        } else {
            // Handle user not found
            throw new RuntimeException("User not found with ID: " + id);
        }
    }
}
