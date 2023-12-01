package rent.tycoon.persistance.config.security.token.impl;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import rent.tycoon.persistance.config.security.token.AccessToken;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@EqualsAndHashCode
@Getter
public class AccessTokenImpl implements AccessToken {
    private final String subject;
    private final int userId;
    private final Set<String> roles;

    public AccessTokenImpl(String subject, int userId, Collection<String> roles) {
        this.subject = subject;
        this.userId = userId;
        this.roles = roles != null ? Set.copyOf(roles) : Collections.emptySet();
    }

    @Override
    public boolean hasRole(String roleName) {
        return this.roles.contains(roleName);
    }
}
