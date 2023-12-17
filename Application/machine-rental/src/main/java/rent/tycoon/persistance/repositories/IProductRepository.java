package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rent.tycoon.domain.IProduct;
import rent.tycoon.persistance.databases.entity.AccessoryJpaMapper;
import rent.tycoon.persistance.databases.entity.MachineJpaMapper;
import rent.tycoon.persistance.databases.entity.ProductJpaMapper;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductJpaMapper, String> {
    boolean existsByName(String name);
    @Query("SELECT p FROM ProductJpaMapper p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<ProductJpaMapper> findProductByName(@Param("name") String name);

    @Query("SELECT p FROM MachineJpaMapper p JOIN p.categories c WHERE c.id = :categoryId")
    List<ProductJpaMapper> findByCategoryId(@Param("categoryId") Integer categoryId);

    @Query("SELECT p FROM ProductJpaMapper p WHERE p.id = :id")
    ProductJpaMapper findByProductId (@Param("id") Long id);


    @Query("SELECT m FROM MachineJpaMapper m " +
            "JOIN m.categories c " +
            "WHERE (:name IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:price IS NULL OR m.price <= :price) " +
            "AND (:category IS NULL OR c.id = :category)")
    List<MachineJpaMapper> findMachinesByFilter(
            @Param("name") String name,
            @Param("price") Integer price,
            @Param("category") long category
    );


}
