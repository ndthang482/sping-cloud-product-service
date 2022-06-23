package savvycom.productservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Image;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOutput {
    private Long id;

    private String optional;

    private int product_line_id;

    private double price;

    private int active;

    private List<Image> images;

    private Date created_at;

    private Date modified_at;

}
