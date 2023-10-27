package rent.tycoon.business.exeption;

public class ProductAlreadyExistsException extends ProductCustomException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
