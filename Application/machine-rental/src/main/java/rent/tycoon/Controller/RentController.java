package rent.tycoon.Controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.Controller.Converters.CreateRentConverter;
import rent.tycoon.business.servicesImpl.RentService;
import rent.tycoon.domain.Rent;
import rent.tycoon.domain.dto.CreateRentDTO;

@RestController
@RequestMapping("/rent")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:")
public class RentController {
    private final RentService rentService;

    @PostMapping
    public ResponseEntity<CreateRentResponse> createPost(@Valid CreateRentRequest request) {
        CreateRentDTO createRentDTO = CreateRentConverter.toCreateRent(request);
        Rent createdRent = rentService.createRent(createRentDTO);

        CreateRentResponse response = CreateRentConverter.responseConverter(createdRent);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
