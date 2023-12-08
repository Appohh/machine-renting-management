package rent.tycoon.controller;

import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.interfaces.service_interfaces.ICategoryService;
import rent.tycoon.business.model.response.CategoryResponseModel;


@RestController()
@RequestMapping("/machine")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private final ICategoryService inputBoundary;

    public CategoryController(ICategoryService inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @GetMapping("/categories")
    public CategoryResponseModel getCategories(){
        return this.inputBoundary.getCategories();
    }
}
