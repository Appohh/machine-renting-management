package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Category;
import rent.tycoon.persistance.databases.entity.CategoryJpaMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryConverter {
    public static Category toCategory(CategoryJpaMapper categoryJpaMapper){
        return Category.builder()
                .id(categoryJpaMapper.getId())
                .name(categoryJpaMapper.getName())
                .build();
    }

    public static Set<CategoryJpaMapper> mapCategory(Set<Category> categories) {
        Set<CategoryJpaMapper> categoryJpaMappers = new HashSet<>();

        if (categories != null) {
            for (Category category : categories) {
                CategoryJpaMapper mappedCategory = CategoryJpaMapper.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build();

                categoryJpaMappers.add(mappedCategory);
            }
        }
        return categoryJpaMappers;
    }

    public static Set<Integer> mapCategoryJpaMappers(Set<CategoryJpaMapper> categoryJpaMappers) {

        return categoryJpaMappers.stream()
                .map(CategoryJpaMapper::getId)
                .collect(Collectors.toSet());
    }

    public static List<Category> mapJpaCategory(List<CategoryJpaMapper> categories) {
        List<Category> categoryJpaMappers = new ArrayList<>();

        if (categories != null) {
            for (CategoryJpaMapper category : categories) {
                Category mappedCategory = Category.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build();

                categoryJpaMappers.add(mappedCategory);
            }
        }
        return categoryJpaMappers;
    }
}
