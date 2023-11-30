package rent.tycoon.persistance.config.token;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
