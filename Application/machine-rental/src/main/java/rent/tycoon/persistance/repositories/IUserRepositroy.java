package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;

@Repository
public interface IUserRepositroy extends JpaRepository<UserJpaMapper, String> {

    UserJpaMapper findUserJpaMapperByEmail(String email);
}
