package rent.tycoon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.tycoon.business.interfaces.service_interfaces.IAuthService;
import rent.tycoon.business.interfaces.service_interfaces.IDiscountService;
import rent.tycoon.business.model.request.discount.DiscountRequestModel;
import rent.tycoon.business.model.response.discount.DiscountResponseModel;

@RestController()
@RequestMapping("/discount")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class DiscountController {
    private final IDiscountService discountService;
    private final IAuthService authService;

    @PostMapping
    public ResponseEntity<Object> applyDiscount(@RequestHeader("Authorization") String authorizationHeader, @RequestBody @Valid DiscountRequestModel discountRequestModel) {
         try {
             String token = extractTokenFromAuthorizationHeader(authorizationHeader);
             long userId = authService.extractUserIdFromToken(token);
             DiscountResponseModel responseModel = discountService.applyDiscount(discountRequestModel, userId);
             return ResponseEntity.ok(responseModel);
         }catch (Exception e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("AN error occurred during applying discount code");
         }
    }

    private String extractTokenFromAuthorizationHeader(String authorizationHeader) {
        return authorizationHeader.replaceFirst("Bearer ", "").trim();
    }
}

