package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rent.tycoon.business.model.request.customer.CreateCustomerRequestModel;
import rent.tycoon.business.model.response.customer.CreateCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetAllCustomerResponseModel;
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
public class CustomerService {

    private final IUserRepository userRepositroy;
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

    private UserJpaMapper saveCustomer(CreateCustomerRequestModel requestModel)
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

}
