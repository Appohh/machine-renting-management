package rent.tycoon.business.interfaces.service_interfaces;

import rent.tycoon.business.model.request.customer.CreateCustomerRequestModel;
import rent.tycoon.business.model.request.customer.UpdateCustomerRequestModel;
import rent.tycoon.business.model.response.customer.CreateCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetAllCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetCustomerResponseModel;
import rent.tycoon.domain.Customer;
import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;

import java.util.Date;

public interface ICustomerService {
    CreateCustomerResponseModel createCustomer(CreateCustomerRequestModel request);
    UserJpaMapper saveCustomer(CreateCustomerRequestModel requestModel);
    Customer UpdateUserDetails(UpdateCustomerRequestModel requestModel);
    GetAllCustomerResponseModel getAllCustomer();
    GetCustomerResponseModel getUserById(Long id);
}
