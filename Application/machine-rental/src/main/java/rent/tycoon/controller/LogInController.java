package rent.tycoon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.model.request.customer.LogInRequestModel;
import rent.tycoon.business.model.response.customer.LogInResponseModel;
import rent.tycoon.business.services.LogInService;

@RestController
@RequestMapping("/tokens")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class LogInController {
    private final LogInService logInService;

    @PostMapping
    public ResponseEntity<LogInResponseModel> login(@RequestBody @Valid LogInRequestModel loginRequest) {
        LogInResponseModel loginResponse = logInService.logIn(loginRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
    }
}
