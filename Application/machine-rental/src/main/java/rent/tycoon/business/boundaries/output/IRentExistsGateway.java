package rent.tycoon.business.boundaries.output;

public interface IRentExistsGateway {
    public boolean existsByProductId(long productId);
}
