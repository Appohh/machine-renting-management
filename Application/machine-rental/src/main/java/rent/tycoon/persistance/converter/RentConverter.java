package rent.tycoon.persistance.converter;

import rent.tycoon.domain.Rent;
import rent.tycoon.persistance.databases.entity.FilesJpaMapper;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.ArrayList;
import java.util.List;

public class RentConverter {

//    public static RentJpaMapper convertToRentJpaMapper(Rent rent) {
//        RentRowJpaMapper rentRowJpaMapper = convertToRentRowJpaMapper(rent);
//        return RentJpaMapper.builder()
//                .customerId(rent.getCustomerId())
//                .address(rent.getAddress())
//                .city(rent.getCity())
//                .timestamp(rent.getTimestamp())
//                .total(rent.getTotal())
//                .discount(rent.getDiscount())
//                .paid(rent.getPaid())
//                .rentRowJpaMapper(rentRowJpaMapper)
//                .build();
//    }
//
//    public static List<RentRowJpaMapper> convertToRentRowJpaMapper(Rent rent) {
//        List<RentRowJpaMapper> jpaRent = new ArrayList<>();
//        if (rent != null){
//        return RentRowJpaMapper.builder()
//                .rentId(rent.getId())
//                .productId(rent.getProduct_id())
//                .startDate(rent.getStartDate())
//                .endDate(rent.getEndDate())
//                .timestamp(rent.getTimestamp())
//                .build();
//    }
}
