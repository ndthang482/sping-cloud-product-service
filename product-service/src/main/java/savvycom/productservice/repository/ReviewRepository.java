package savvycom.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.Review;
import savvycom.productservice.service.IReviewService;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    @Query(value = "SELECT * FROM review WHERE id=?1", nativeQuery = true)
    Optional<Review> findById(Long id);

}
