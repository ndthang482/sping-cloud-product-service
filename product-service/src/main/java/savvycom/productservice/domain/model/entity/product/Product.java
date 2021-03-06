package savvycom.productservice.domain.model.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity

@Table(name="product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String color;

    private String size;

    private Long productLineId;
    
    private BigDecimal price;

    private Long discountId;

    private Long active;

    private Date createdAt;

    private Date modifiedAt;

}