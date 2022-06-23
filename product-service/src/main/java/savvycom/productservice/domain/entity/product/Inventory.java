package savvycom.productservice.domain.entity.product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name ="inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int branchId;

    private int productId;

    private int quantity;

    private Timestamp createdAt;

    private Timestamp modifiedAt;

}
