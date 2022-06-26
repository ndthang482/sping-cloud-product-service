package savvycom.productservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import savvycom.productservice.domain.entity.product.Product;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private BigDecimal price;
    public ProductDTO(Product product){
        this.id = product.getId();
        this.price = product.getPrice();
    }
}
