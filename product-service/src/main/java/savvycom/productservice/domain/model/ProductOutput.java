package savvycom.productservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Image;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOutput {
    private Long id;

    private String color;

    private String size;

    private Long productLineId;

    private BigDecimal price;

    private Long discountId;

    private Long active;

    private List<Image> images;

    private Date created_at;

    private Date modified_at;
}
