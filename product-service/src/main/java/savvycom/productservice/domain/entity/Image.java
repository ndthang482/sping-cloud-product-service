package savvycom.productservice.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table
@Entity(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private int product_id;

    private String url;

    private String desc;

   private Timestamp created_at;

   private Timestamp modified_at;
}
