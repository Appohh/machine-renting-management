package rent.tycoon.business.boundaries.output;

public interface IProductExistsGateway {

    boolean existsById (String id);
    boolean existsByName (String name);
}
