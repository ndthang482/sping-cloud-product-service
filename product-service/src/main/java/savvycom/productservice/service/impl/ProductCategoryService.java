package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.product.ProductCategory;
import savvycom.productservice.repository.product.ProductCategoryRepository;
import savvycom.productservice.service.product.IProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void delete(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return (List<ProductCategory>) productCategoryRepository.findAll();
    }
    @Override
    public ProductCategory findById(long id) {
        return (ProductCategory) productCategoryRepository.findById(id).orElse(null);
    }
}
