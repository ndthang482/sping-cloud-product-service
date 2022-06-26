package savvycom.productservice.repository.product;
// @Repo access database, class click database.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.product.Product;
import savvycom.productservice.domain.model.ProductOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    @Query(value = "SELECT * FROM product WHERE price BETWEEN 0 AND 1000000 ORDER BY price desc", nativeQuery = true)
    List<Product> findByPriceLess1M(BigDecimal price);

    @Query(value = "SELECT * FROM product WHERE price BETWEEN 1000000 AND 3000000 ORDER BY price desc", nativeQuery = true)
    List<Product> findByPriceLess3M(BigDecimal price);

    @Query(value = "SELECT * FROM product WHERE price BETWEEN 3000000 AND 8000000 ORDER BY price desc", nativeQuery = true)
    List<Product> findByPriceAbove3M(BigDecimal price);

    List<Product> findProductByColor(String color);

    List<Product> findProductBySize(String size);

}
