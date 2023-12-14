package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.repo_interfaces.IUserRepo;
import rent.tycoon.business.interfaces.service_interfaces.ICustomerService;
import rent.tycoon.business.model.request.customer.CreateCustomerRequestModel;
import rent.tycoon.business.model.response.customer.CreateCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetAllCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetCustomerResponseModel;
import rent.tycoon.domain.Customer;
import rent.tycoon.persistance.converter.CustomerConverter;
import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;
import rent.tycoon.persistance.databases.entity.User.UserRoleJpaMapper;
import rent.tycoon.persistance.databases.entity.User.UserRoles;
import rent.tycoon.persistance.repositories.IUserRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final IUserRepository userRepositroy;
    private final IUserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    //CreateCustomer
    public CreateCustomerResponseModel createCustomer(CreateCustomerRequestModel request)
    {
        UserJpaMapper saveCustomer = saveCustomer(request);

        return CreateCustomerResponseModel
                .builder()
                .id(saveCustomer.getId())
                .build();
    }

    public UserJpaMapper saveCustomer(CreateCustomerRequestModel requestModel)
    {
        String hashedPassword = passwordEncoder.encode(requestModel.getPassword());

        UserJpaMapper newCustomer = UserJpaMapper
                .builder()
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .birthDate(requestModel.getBirthdate())
                .address(requestModel.getAddress())
                .city(requestModel.getCity())
                .email(requestModel.getEmail())
                .phone(requestModel.getPhone())
                .timeStamp(new Date())

                .password(hashedPassword)
                .build();

        //roles
        newCustomer.setUserRoles(Set.of(
                UserRoleJpaMapper.builder()
                        .user(newCustomer)
                        .role(UserRoles.Customer)
                        .build()));

        return userRepositroy.save(newCustomer);
    }
    public Customer UpdateUserDetails(Long id, String firstName, String lastName, Date birthDate, String address, String city, String email, int phone){
        return userRepo.updateUserDetails(id, firstName, lastName, birthDate, address, city, email, phone);
    }
    //GetAllCustomer
    //TODO: Change to get users with the specific role
    public GetAllCustomerResponseModel getAllCustomer()
    {
        List<UserJpaMapper> userJpaMappers;
        userJpaMappers = userRepositroy.findAll();

        List<Customer> customers = userJpaMappers
                .stream()
                .map(CustomerConverter::CustomerConvert)
                .toList();

        return GetAllCustomerResponseModel.builder().customers(customers).build();
    }

    public GetCustomerResponseModel getUserById(Long id){
        UserJpaMapper userJpaMapper;

        userJpaMapper = userRepositroy.findUserById(id);

        Customer customer = CustomerConverter.CustomerConvert(userJpaMapper);

        return GetCustomerResponseModel.builder().user(customer).build();
    }

}
