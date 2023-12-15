package rent.tycoon.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.interfaces.service_interfaces.IRentService;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.interfaces.service_interfaces.IRentService2;
import rent.tycoon.business.model.request.CreateRentRequest2;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;
import rent.tycoon.business.model.response.GetAllRentResponseModel;


@RestController
@RequestMapping("/rent")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class RentController {

    private final IRentService inputBoundary;
    private final IRentService2 rentService2;
    public RentController(IRentService inputBoundary, IRentService2 rentService2){this.inputBoundary = inputBoundary; this.rentService2=rentService2;}

    @PostMapping("/1")
    public CreateRentResponseModel createPost(@Valid @RequestBody CreateRentRequestModel requestModel) throws RentCustomException {
        return this.inputBoundary.create(requestModel);
    }
    @PostMapping
    public CreateRentResponseModel createRent2(@Valid @RequestBody CreateRentRequest2 requestModel) throws RentCustomException {
        return this.rentService2.create(requestModel);
    }
    @GetMapping("{customer_id}")
    public GetAllRentResponseModel getAllRents(@PathVariable("customer_id") long customerId)  throws RentCustomException{
        return this.rentService2.getAllRents(customerId);
    }
}