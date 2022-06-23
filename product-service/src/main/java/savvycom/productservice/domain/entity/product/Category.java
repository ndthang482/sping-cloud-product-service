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
@Table(name="category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String desc;

    private Timestamp createdAt;

    private Timestamp modifiedAt;

}
