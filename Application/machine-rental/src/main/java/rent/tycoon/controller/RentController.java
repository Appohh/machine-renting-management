package rent.tycoon.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.interfaces.service_interfaces.IAuthService;
import rent.tycoon.business.interfaces.service_interfaces.IRentService;
import rent.tycoon.business.exeption.RentCustomException;
import rent.tycoon.business.model.request.rent.AddRentRowRequestModel;
import rent.tycoon.business.model.request.rent.CreateRentRequestModel;
import rent.tycoon.business.model.response.rent.AddRentRowResponseModel;
import rent.tycoon.business.model.response.rent.CreateRentResponseModel;


@RestController
@RequestMapping("/rent")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class RentController {

    private final IRentService rentService;
    private final IAuthService authService;

    public RentController(IRentService inputBoundary, IAuthService authService){
        this.rentService = inputBoundary;
        this.authService = authService;
    }

    @PostMapping()
    public ResponseEntity<Object> createRent(@RequestHeader("Authorization") String authorizationHeader, @Valid @RequestBody CreateRentRequestModel requestModel){
        try {
            String token = extractTokenFromAuthorizationHeader(authorizationHeader);

            long userId = authService.extractUserIdFromToken(token);

            if (requestModel.getCustomerId() == userId){
                CreateRentResponseModel responseModel = rentService.create(requestModel);
                return ResponseEntity.ok(responseModel);
            }
            else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User isn't allowed to create this rent.");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during the creation");
        }

    }

    @PostMapping("/addRentRow")
    public ResponseEntity<Object> addRentRowToRent(@RequestHeader("Authorization") String authorizationHeader, @Valid @RequestBody AddRentRowRequestModel requestModel){
        try {
            String token = extractTokenFromAuthorizationHeader(authorizationHeader);

            long userId = authService.extractUserIdFromToken(token);

            if (Boolean.TRUE.equals(rentService.userOwnsRent(userId, requestModel.getRentId()))){
                 AddRentRowResponseModel responseModel = rentService.addRentRow(requestModel);
                 return ResponseEntity.ok(responseModel);
            }
            else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User doesn't own this rent.");
            }
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during the creation");
        }

    }

//    @GetMapping("{customer_id}")
//    public GetAllRentResponseModel getAllRents(@PathVariable("customer_id") long customerId)  throws RentCustomException{
//        return this.rentService2.getAllRents(customerId);
//    }


    private String extractTokenFromAuthorizationHeader(String authorizationHeader) {
        return authorizationHeader.replaceFirst("Bearer ", "").trim();
    }
}