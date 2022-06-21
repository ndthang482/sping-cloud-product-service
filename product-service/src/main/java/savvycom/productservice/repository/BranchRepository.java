package savvycom.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.Branch;

import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query(value = "SELECT * FROM branch WHERE id=?1", nativeQuery = true)
    Optional<Branch> findById(Long id);
}
