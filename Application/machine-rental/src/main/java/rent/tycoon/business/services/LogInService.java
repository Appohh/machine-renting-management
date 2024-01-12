package rent.tycoon.business.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rent.tycoon.business.exeption.InvalidCredentialsException;
import rent.tycoon.business.model.request.customer.LogInRequestModel;
import rent.tycoon.business.model.response.customer.LogInResponseModel;
import rent.tycoon.config.security.token.AccessTokenEncoder;
import rent.tycoon.config.security.token.impl.AccessTokenImpl;
import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;
import rent.tycoon.persistance.repositories.IUserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class LogInService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //token
    private final AccessTokenEncoder accessTokenEncoder;

    //Login
    public LogInResponseModel logIn(LogInRequestModel requestModel)
    {
        UserJpaMapper userJpaMapper = userRepository.findUserJpaMapperByEmail(requestModel.getEmailAddress());

        if (userJpaMapper == null)
        {
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(requestModel.getPassword(), userJpaMapper.getPassword()))
        {
            throw new InvalidCredentialsException();
        }

        String accessToken = generateAccessToken(userJpaMapper);

        return LogInResponseModel.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {

        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private  String generateAccessToken(UserJpaMapper user)
    {
        List<String> roles = user.getUserRoles().stream()
                .map(userRole -> userRole.getRole().toString())
                .toList();

        return accessTokenEncoder.encode(
                new AccessTokenImpl(user.getEmail(), user.getId(), roles));
    }

}
