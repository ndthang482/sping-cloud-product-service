package savvycom.productservice.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String address_id;

    private Timestamp created_at;

    private Timestamp modified_at;
}
