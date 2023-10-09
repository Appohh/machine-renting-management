package rent.tycoon.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
@AllArgsConstructor
@Builder
@Getter
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String address;
    private String city;
    private String email;
    private int phone;
    private Date timestamp;
}
