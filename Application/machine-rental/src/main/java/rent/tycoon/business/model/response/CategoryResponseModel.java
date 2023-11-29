package rent.tycoon.business.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rent.tycoon.domain.Category;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseModel {
    List<Category> categories;
}
