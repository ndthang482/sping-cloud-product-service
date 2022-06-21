package savvycom.productservice.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.product.ProductLine;

import java.util.Optional;
@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {
    @Query(value = "SELECT * FROM product_line WHERE id=?1", nativeQuery = true)
    Optional<ProductLine> findById(Long id);
}
