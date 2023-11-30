package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.tycoon.persistance.repositories.IUserRepositroy;

@Service
@AllArgsConstructor
public class CustomerService {

    private final IUserRepositroy userRepositroy;
    private final BCryptPasswordEncoder passwordEncoder;
}
