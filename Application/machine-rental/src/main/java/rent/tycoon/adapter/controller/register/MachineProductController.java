package rent.tycoon.adapter.controller.register;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.boundaries.input.register.IMachineRegisterBoundary;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.CreateMachineRequestModel;
import rent.tycoon.business.model.response.CreateMachineResponseModel;

import java.math.BigDecimal;
import java.util.List;

@RestController()
@RequestMapping("/Machine")
public class MachineProductController {
    private final IMachineRegisterBoundary inputBoundary;


    public MachineProductController(IMachineRegisterBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping
    public CreateMachineResponseModel create(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("status") int status, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files) throws ProductCustomException {
        CreateMachineRequestModel requestModel = new CreateMachineRequestModel(name, description, status, price, files);
        return this.inputBoundary.create(requestModel);
    }
}

