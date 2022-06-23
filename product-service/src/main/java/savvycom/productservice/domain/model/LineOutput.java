package savvycom.productservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.Discount;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineOutput {
    private Long id;

    private String name;

    private String desc;

    private int categoryId;

    private int discountId;

    private int active;

    private List<Discount> discounts;

    private Date createdAt;

    private Date modifiedAt;
}
