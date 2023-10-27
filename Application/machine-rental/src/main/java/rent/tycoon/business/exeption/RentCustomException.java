package rent.tycoon.business.exeption;

public class RentCustomException extends Exception{
    public RentCustomException(){

    }
    public RentCustomException(String message){super(message);}

    public RentCustomException(String message, Throwable cause){super (message, cause);}
}
