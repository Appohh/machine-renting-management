package rent.tycoon.persistance.converter;


import rent.tycoon.domain.Rent;
import rent.tycoon.domain.RentRow;
import rent.tycoon.persistance.databases.entity.RentJpaMapper;
import rent.tycoon.persistance.databases.entity.RentRowJpaMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentConverter {


    public static RentJpaMapper toRentJpaEntity(Rent rent) {
        List <RentRowJpaMapper> toRentRowJpaEntity = toRentRowJpaEntity(rent);
        return RentJpaMapper.builder()
                .id(rent.getId())
                .customerId(rent.getCustomerId())
                .address(rent.getAddress())
                .city(rent.getCity())
                .timestamp(rent.getTimestamp())
                .total(rent.getTotal())
                .discount(rent.getDiscount())
                .paid(rent.getPaid())
                .rentRow(toRentRowJpaEntity)
                .build();
    }

    public static List <RentRowJpaMapper> toRentRowJpaEntity(Rent rent) {
        List<RentRowJpaMapper> jpaRentRows = new ArrayList<>();
        if (rent != null){
            for (RentRow row : rent.getRows()) {
                jpaRentRows.add(createJpaRentRow(row.getStartDate(), row.getEndDate(), row.getProductId()));
            }
        }
        return jpaRentRows;
    }


    private static RentRowJpaMapper createJpaRentRow(Date startDate, Date endDate, long productId) {
        return RentRowJpaMapper.builder()
                .startDate(startDate)
                .endDate(endDate)
                .productId(productId)
                .build();
    }
}
