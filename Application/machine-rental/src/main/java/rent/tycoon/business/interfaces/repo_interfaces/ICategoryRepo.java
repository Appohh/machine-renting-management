package rent.tycoon.business.interfaces.repo_interfaces;

import rent.tycoon.domain.Category;

import java.util.List;
import java.util.Set;

public interface ICategoryRepo {
    List<Category> getCategories();
}
