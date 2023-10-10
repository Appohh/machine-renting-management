package rent.tycoon.Controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rent.tycoon.Controller.Converters.CreateRentConverter;
import rent.tycoon.business.Converters.RentConverter;
import rent.tycoon.business.servicesImpl.RentService;
import rent.tycoon.domain.dto.CreateRent;

import java.util.List;

@RestController
@RequestMapping("/rent")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:")
public class RentController {
    private final RentService rentService;

    @PostMapping
    public ResponseEntity<CreateRentResponse> createPost(@Valid CreateRentRequest request) {
        CreateRent createRent = CreateRentConverter.toCreateRent(request);
        CreateRent createdRent = rentService.createRent(createRent);

        CreateRentResponse response = CreateRentConverter.responseConverter(createdRent);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
