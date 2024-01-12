package rent.tycoon.business.interfaces.service_interfaces;

import java.util.Set;

public interface IAuthService {
    Set<String> extractRolesFromToken(String accessTokenEncoded);
    long extractUserIdFromToken(String accessTokenEncoded);
}
