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
@Table(name ="product_inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int branch_id;

    private int product_id;

    private int quantity;

    private Timestamp created_at;

    private Timestamp modified_at;

}
