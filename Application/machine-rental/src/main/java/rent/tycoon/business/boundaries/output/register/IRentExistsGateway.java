package rent.tycoon.business.boundaries.output.register;

public interface IRentExistsGateway {
    boolean existsByProductId(long productId);
}
