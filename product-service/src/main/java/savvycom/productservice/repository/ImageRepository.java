package savvycom.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.Image;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "SELECT * FROM image WHERE id=?1", nativeQuery = true)
    Optional<Image> findById(Long id);
    @Query(value = "SELECT * FROM image WHERE product_id=?1", nativeQuery = true)
    Optional<Image> findByProductId(int product_id);
}
