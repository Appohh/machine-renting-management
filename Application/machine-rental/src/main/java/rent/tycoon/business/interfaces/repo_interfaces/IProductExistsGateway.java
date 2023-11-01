package rent.tycoon.business.interfaces.repo_interfaces;

public interface IProductExistsGateway {

    boolean existsById (String id);
    boolean existsByName (String name);
}
