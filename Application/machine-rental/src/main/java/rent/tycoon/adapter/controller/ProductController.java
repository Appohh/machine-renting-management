package rent.tycoon.adapter.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.boundaries.input.IProductBoundary;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.create.CreateAccessoryRequestModel;
import rent.tycoon.business.model.request.create.CreateMachineRequestModel;
import rent.tycoon.business.model.response.CreateProductResponseModel;
import rent.tycoon.business.model.response.GetProductResponseModel;

import java.math.BigDecimal;
import java.util.List;

@RestController()
@RequestMapping("/Product")
public class ProductController {
    private final IProductBoundary inputBoundary;


    public ProductController(IProductBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping("/machine")
    public CreateProductResponseModel createMachine(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("status") int status, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files, @RequestParam("machineSpecificField") String machineSpecificField ) throws ProductCustomException {
        CreateMachineRequestModel requestModel = new CreateMachineRequestModel(name, description, status, price, files, "machine" , machineSpecificField);
        return this.inputBoundary.create(requestModel);
    }
    @PostMapping("/accessory")
    public CreateProductResponseModel createAccessory(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("status") int status, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files, @RequestParam("accessorySpecificField") String accessorySpecificField ) throws ProductCustomException {
        CreateAccessoryRequestModel requestModel = new CreateAccessoryRequestModel(name, description, status, price, files, "accessory" , accessorySpecificField);
        return this.inputBoundary.create(requestModel);
    }

    @GetMapping("{name}")
    public GetProductResponseModel findByProductName(@PathVariable("name") String name) throws ProductCustomException {
        return this.inputBoundary.findProductByName(name);
    }
}

