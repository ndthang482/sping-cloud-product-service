package savvycom.productservice.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.product.Product;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE id=?1", nativeQuery = true)
    Optional<Product> findById(Long id);

}
