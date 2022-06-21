package savvycom.productservice.repository.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.product.ProductInventory;

import java.util.Optional;
@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
    @Query(value = "SELECT * FROM product_inventory WHERE id=?1", nativeQuery = true)
    Optional<ProductInventory> findById(Long id);
}
