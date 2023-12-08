package rent.tycoon.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rent.tycoon.domain.IProduct;
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
}
