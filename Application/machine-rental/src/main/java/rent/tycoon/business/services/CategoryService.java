package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.repo_interfaces.ICategoryRepo;
import rent.tycoon.business.interfaces.service_interfaces.ICategoryService;
import rent.tycoon.business.model.response.CategoryResponseModel;
import rent.tycoon.domain.Category;


import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    private ICategoryRepo gateway;
    @Override
    public CategoryResponseModel getCategories() {
        List<Category> categories = gateway.getCategories();
        return new CategoryResponseModel(categories);
    }
}
