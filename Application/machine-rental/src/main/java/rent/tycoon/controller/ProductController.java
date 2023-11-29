package rent.tycoon.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.business.interfaces.service_interfaces.IProductService;
import rent.tycoon.business.exeption.ProductCustomException;
import rent.tycoon.business.model.request.accessory.CreateAccessoryRequestModel;
import rent.tycoon.business.model.request.accessory.UpdateAccessoryRequestModel;
import rent.tycoon.business.model.request.machine.CreateMachineRequestModel;
import rent.tycoon.business.model.request.machine.UpdateMachineRequestModel;
import rent.tycoon.business.model.response.*;
import rent.tycoon.domain.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("/Product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final IProductService inputBoundary;


    public ProductController(IProductService inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping("/machine")
    public CreateProductResponseModel createMachine(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files, @RequestParam("machineSpecificField") String machineSpecificField, @RequestParam("category")Set<Integer> category) throws ProductCustomException {
        CreateMachineRequestModel requestModel = new CreateMachineRequestModel(name, description, 0, price, files, machineSpecificField, category);
        return this.inputBoundary.create(requestModel);
    }
    @PostMapping("/accessory")
    public CreateProductResponseModel createAccessory(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("status") int status, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files, @RequestParam("accessorySpecificField") String accessorySpecificField ) throws ProductCustomException {
        CreateAccessoryRequestModel requestModel = new CreateAccessoryRequestModel(name, description, status, price, files, accessorySpecificField);
        return this.inputBoundary.create(requestModel);
    }

    @GetMapping("/mapping/{name}")
    public GetProductResponseModel findByProductName(@PathVariable("name") String name) throws ProductCustomException {
        return this.inputBoundary.findProductByName(name);
    }

    @PostMapping("/machine/update")
    public UpdateProductResponseModel updateMachine(@RequestParam("id") long id,@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("status") int status, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files, @RequestParam("machineSpecificField") String machineSpecificField, Set<Integer> category) throws ProductCustomException{
        UpdateMachineRequestModel requestModel = new UpdateMachineRequestModel(id, name, description, status, price, files, machineSpecificField, category);
        return this.inputBoundary.update(requestModel);
    }

    @PostMapping("/accessory/update")
    public UpdateProductResponseModel updateAccessory(@RequestParam("id") long id,@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("status") int status, @RequestParam("price") BigDecimal price, @RequestParam ("files") List<MultipartFile> files, @RequestParam("accessorySpecificField") String accessorySpecificField) throws ProductCustomException{
        UpdateAccessoryRequestModel requestModel = new UpdateAccessoryRequestModel(id, name, description, status, price, files, accessorySpecificField);
        return this.inputBoundary.update(requestModel);
    }

    @GetMapping("{id}")
    public GetProductbyIdResponseModel findByProductId(@PathVariable("id") Long id) {
        return this.inputBoundary.getProductbyId(id);
    }

    @GetMapping("/filter/{id}")
    public FilterMachineResponseModel findMachineByCategory(@PathVariable("id") Integer id){
        return this.inputBoundary.getMachineByCategory(id);
    }

}

