package rent.tycoon.Controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.dto.CreateRentRequest;
import rent.tycoon.business.dto.CreateRentResponse;
import rent.tycoon.business.servicesImpl.RentService;

@RestController
@RequestMapping("/rent")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:")
public class RentController {
    private final RentService rentService;

    @PostMapping
    public ResponseEntity<CreateRentResponse> createPost(@Valid @RequestBody CreateRentRequest request) {
        CreateRentResponse response = rentService.createRent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
