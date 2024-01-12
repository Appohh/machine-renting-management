package rent.tycoon.config.security.token;

import java.util.Set;

public interface AccessToken {
    String getSubject();

    int getUserId();

    Set<String> getRoles();

    boolean hasRole(String roleName);
}
