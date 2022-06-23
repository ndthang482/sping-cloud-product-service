package savvycom.productservice.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.product.Category;

import java.util.Optional;
@Repository
public interface ProductCategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT * FROM product_category WHERE id=?1", nativeQuery = true)

    Optional<Category> findById(Long id);
}
