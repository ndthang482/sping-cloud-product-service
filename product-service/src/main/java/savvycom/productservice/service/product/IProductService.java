package savvycom.productservice.service.product;

import savvycom.productservice.domain.dto.ProductDTO;
import savvycom.productservice.domain.entity.product.Product;

import java.util.List;

public interface IProductService {
    Product save(Product product);
    void delete(Long id);

    List<Product> findAll();

    Product findById(long id);

    List<ProductDTO> findProductDTOById(Long id);
}
