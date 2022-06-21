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

@Table(name="product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String optional;

    private int product_line_id;
    
    private double price;

    private int active;

    private Timestamp created_at;

    private Timestamp modified_at;


}
