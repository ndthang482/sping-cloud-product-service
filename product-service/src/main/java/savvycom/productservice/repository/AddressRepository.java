package savvycom.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import savvycom.productservice.domain.entity.Address;

import java.util.Optional;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "SELECT * FROM address WHERE id=?1", nativeQuery = true)
    Optional<Address> findById(Long id);
}
