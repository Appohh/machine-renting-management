package rent.tycoon.persistance.converter;

import org.springframework.stereotype.Service;
import rent.tycoon.domain.DiscountCode;
import rent.tycoon.persistance.databases.entity.DiscountJpaMapper;

@Service
public class DiscountConverter {
    public DiscountCode toDomainObject(DiscountJpaMapper discountJpaMapper){
        return DiscountCode.builder()
                .id(discountJpaMapper.getId())
                .code(discountJpaMapper.getCode())
                .type(discountJpaMapper.getType())
                .value(discountJpaMapper.getValue())
                .build();
    }
}
