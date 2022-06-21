package savvycom.productservice.service.product;

import savvycom.productservice.domain.entity.product.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    ProductCategory save(ProductCategory productCategory);

    void delete(Long id);

    List<ProductCategory> findAll();

    ProductCategory findById(long id);
}
