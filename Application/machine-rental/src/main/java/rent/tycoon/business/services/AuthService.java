package rent.tycoon.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.tycoon.business.interfaces.service_interfaces.IAuthService;
import rent.tycoon.config.security.token.AccessToken;
import rent.tycoon.config.security.token.impl.AccessTokenEncoderDecoderImpl;

import java.util.Set;

@Service
public class AuthService implements IAuthService {
    private final AccessTokenEncoderDecoderImpl tokenEncoderDecoder;

    @Autowired
    public AuthService(AccessTokenEncoderDecoderImpl tokenEncoderDecoder) {
        this.tokenEncoderDecoder = tokenEncoderDecoder;
    }

    public Set<String> extractRolesFromToken(String accessTokenEncoded) {
        AccessToken decodedToken = tokenEncoderDecoder.decode(accessTokenEncoded);
        return decodedToken.getRoles();
    }
    public long extractUserIdFromToken(String accessTokenEncoded) {
        AccessToken decodedToken = tokenEncoderDecoder.decode(accessTokenEncoded);
        return decodedToken.getUserId();
    }
}
