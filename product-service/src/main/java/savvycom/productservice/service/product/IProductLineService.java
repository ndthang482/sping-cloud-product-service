package savvycom.productservice.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import savvycom.productservice.domain.model.entity.product.ProductLine;

import java.util.List;

public interface IProductLineService {
    ProductLine save(ProductLine productLine);

    void delete(Long id);

    List<ProductLine> findAll();

    ProductLine findById(Long id);

//    List<ProductLine> findAllDiscountByLine(Long discountId);

    List<ProductLine> findAllCategoryByLine(Long categoryId);

    List<ProductLine> findByNameLike(String name);

}
