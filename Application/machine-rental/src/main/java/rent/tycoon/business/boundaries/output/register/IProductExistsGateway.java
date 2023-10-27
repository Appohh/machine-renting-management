package rent.tycoon.business.boundaries.output.register;

public interface IProductExistsGateway {
    boolean existsById(String id);
    boolean existsByName(String name);
}
