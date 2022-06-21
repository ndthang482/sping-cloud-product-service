package savvycom.productservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.util.Times;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.security.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int user_id;

    private int product_id;

    private int rate;

    private String content;

    private Timestamp created_at;

    private Timestamp modified_at;
}
