package rent.tycoon.persistance.config.security.token;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
