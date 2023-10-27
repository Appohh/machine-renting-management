package rent.tycoon.adapter.controller.register;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.tycoon.business.boundaries.input.register.IMachineRegisterBoundary;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.CreateMachineRequestModel;
import rent.tycoon.business.model.response.CreateMachineResponseModel;

@RestController()
@RequestMapping("/Machine")
public class MachineProductController {
    private final IMachineRegisterBoundary inputBoundary;


    public MachineProductController(IMachineRegisterBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public CreateMachineResponseModel create(@RequestBody CreateMachineRequestModel requestModel) throws ProductCustomException {
        return this.inputBoundary.create(requestModel);
    }
}

