package rent.tycoon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.tycoon.business.model.request.customer.CreateCustomerRequestModel;
import rent.tycoon.business.model.response.customer.CreateCustomerResponseModel;
import rent.tycoon.business.model.response.customer.GetAllCustomerResponseModel;
import rent.tycoon.business.services.CustomerService;

@RestController
@RequestMapping("/tokens")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;

    //GetAllCustomer
    public ResponseEntity<GetAllCustomerResponseModel> getAllCustomer()
    {
        GetAllCustomerResponseModel responseModel = customerService.getAllCustomer();

        return ResponseEntity.ok(responseModel);
    }

    //CreateCustomer
    public ResponseEntity<CreateCustomerResponseModel> createCustomer(@RequestBody @Valid CreateCustomerRequestModel requestModel)
    {
        CreateCustomerResponseModel responseModel = customerService.createCustomer(requestModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }
}
