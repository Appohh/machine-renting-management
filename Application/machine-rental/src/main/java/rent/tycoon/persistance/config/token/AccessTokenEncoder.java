package rent.tycoon.persistance.config.token;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
