package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Customer;
import rent.tycoon.persistance.databases.entity.User.UserJpaMapper;

public class CustomerConverter {
    public static Customer CustomerConvert(UserJpaMapper user)
    {
        return Customer
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthdate(user.getBirthDate())
                .address(user.getAddress())
                .city(user.getCity())
                .email(user.getEmail())
                .phone(user.getPhone())
                .timeStamp(user.getTimeStamp())

                .password(user.getPassword())
                .build();
    }
}
