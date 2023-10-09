package rent.tycoon.Controller;

import rent.tycoon.domain.CreateRent;
import rent.tycoon.domain.Rent;

public class Converter {

    public Rent rentRequestConverter(CreateRentRequest request){
        Rent rent = new Rent();


        return rent;

    }
    public CreateRentResponse responseConverter(Rent rent){
        CreateRentResponse response = new CreateRentResponse();
        response.setId(response.getId());
        return response;
    }

}
