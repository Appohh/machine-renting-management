package rent.tycoon.business.model.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GetProductRequestModel {
    private String name;
}
