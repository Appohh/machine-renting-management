package rent.tycoon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.interfaces.service_interfaces.ICustomerService;
import rent.tycoon.business.model.request.customer.CreateCustomerRequestModel;
import rent.tycoon.business.model.response.customer.CreateCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetAllCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetCustomerResponseModel;
import rent.tycoon.business.services.CustomerService;
import rent.tycoon.domain.Customer;

import java.util.Date;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final ICustomerService customerService;

    //GetAllCustomer
    @GetMapping()
    public ResponseEntity<GetAllCustomerResponseModel> getAllCustomer()
    {
        GetAllCustomerResponseModel responseModel = customerService.getAllCustomer();

        return ResponseEntity.ok(responseModel);
    }

    //CreateCustomer
    @PostMapping()
    public ResponseEntity<CreateCustomerResponseModel> createCustomer(@RequestBody @Valid CreateCustomerRequestModel requestModel)
    {
        CreateCustomerResponseModel responseModel = customerService.createCustomer(requestModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @GetMapping("/byId/{id}")
    public GetCustomerResponseModel getUserById (@PathVariable("id") long id){
        return this.customerService.getUserById(id);
    }
    @PostMapping("/updateCustomer")
    public Customer updateCustomerCredentials(@RequestParam Long id, @RequestParam String firstName,@RequestParam String lastName,@RequestParam Date birthDate,@RequestParam String address,@RequestParam String city,@RequestParam String email,@RequestParam int phone){
        return customerService.UpdateUserDetails(id, firstName,lastName,birthDate,address,city,email,phone);
    }
}
