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
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String province;

    private String district;

    private String ward;

    private String specific_address;

    private String phone;

   private Timestamp created_at;

   private Timestamp modified_at;
}
