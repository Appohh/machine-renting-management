package rent.tycoon.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.interfaces.service_interfaces.IRentService;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;


@RestController
@RequestMapping("/rent")
@CrossOrigin(origins = "http://localhost:5174")
public class RentController {

    private final IRentService inputBoundary;

    public RentController(IRentService inputBoundary){this.inputBoundary = inputBoundary;}

    @PostMapping
    public CreateRentResponseModel createPost(@Valid @RequestBody CreateRentRequestModel requestModel) throws RentCustomException {
        return this.inputBoundary.create(requestModel);
    }
}
