package rent.tycoon.persistance.databases.mysql;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rent.tycoon.business.interfaces.repo_interfaces.ICategoryRepo;
import rent.tycoon.domain.Category;
import rent.tycoon.persistance.converter.CategoryConverter;
import rent.tycoon.persistance.databases.entity.CategoryJpaMapper;
import rent.tycoon.persistance.repositories.ICategoryRepository;

import java.util.*;

@Repository
public class CategoryMySqlGateway implements ICategoryRepo {
    ICategoryRepository repository;

    @Autowired
    public CategoryMySqlGateway (ICategoryRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Category> getCategories() {
        List<CategoryJpaMapper> categoryJpaMapper = repository.findAll();
        return CategoryConverter.mapJpaCategory(categoryJpaMapper);
    }
}
