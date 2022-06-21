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
@Table(name="product_line")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String desc;

    private int category_id;

    private int discount_id;

    private int active;

    private Timestamp created_at;

    private Timestamp modified_at;


}
