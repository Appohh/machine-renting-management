package rent.tycoon.persistance.databases.mysql;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import rent.tycoon.business.interfaces.repo_interfaces.IDiscountRepo;
import rent.tycoon.domain.DiscountCode;
import rent.tycoon.persistance.converter.DiscountConverter;
import rent.tycoon.persistance.databases.entity.DiscountJpaMapper;
import rent.tycoon.persistance.repositories.IDiscountRepository;

@Repository
@RequiredArgsConstructor
public class DiscountMySqlGateway implements IDiscountRepo {
    private final IDiscountRepository repository;
    private final DiscountConverter converter;

    public DiscountCode checkDiscountCode(String code){
        DiscountJpaMapper discountJpaMapper = repository.findByCode(code);
        return converter.toDomainObject(discountJpaMapper);
    }
}
