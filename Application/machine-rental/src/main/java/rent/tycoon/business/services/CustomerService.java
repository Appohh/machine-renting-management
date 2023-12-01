package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rent.tycoon.business.model.request.customer.CreateCustomerRequestModel;
import rent.tycoon.business.model.response.customer.CreateCustomerResponseModel;
import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;
import rent.tycoon.persistance.databases.entity.User.UserRoleJpaMapper;
import rent.tycoon.persistance.databases.entity.User.UserRoles;
import rent.tycoon.persistance.repositories.IUserRepositroy;

import java.util.Date;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerService {

    private final IUserRepositroy userRepositroy;
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
                .build();

        //roles
        newCustomer.setUserRoles(Set.of(
                UserRoleJpaMapper.builder()
                        .user(newCustomer)
                        .role(UserRoles.Customer)
                        .build()));
    }

    //GetAllCustomer

    //
}
