package rent.tycoon.config.security.token;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
