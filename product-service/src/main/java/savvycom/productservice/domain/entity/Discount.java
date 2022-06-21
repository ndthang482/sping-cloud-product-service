package savvycom.productservice.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String desc;

    private String discount_percent;

    private int active;

    private Timestamp created_at;

    private Timestamp modified_at;

}
