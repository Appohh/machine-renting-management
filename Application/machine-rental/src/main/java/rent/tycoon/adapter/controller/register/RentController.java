package rent.tycoon.adapter.controller.register;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.boundaries.input.register.IRentRegisterBoundary;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.CreateRentRequestModel;
import rent.tycoon.business.model.response.CreateRentResponseModel;

@RestController
@RequestMapping("/rent")
@CrossOrigin(origins = "http://localhost:5173")
public class RentController {

    private final IRentRegisterBoundary inputBoundary;

    public RentController(IRentRegisterBoundary inputBoundary){this.inputBoundary = inputBoundary;}

    @PostMapping
    public CreateRentResponseModel createPost(@Valid @RequestBody CreateRentRequestModel requestModel) throws RentCustomException {
        return this.inputBoundary.create(requestModel);
    }
}
