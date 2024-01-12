package rent.tycoon.config.security.token;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
