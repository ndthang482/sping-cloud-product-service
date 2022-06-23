package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.product.Category;
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
    public Category save(Category category) {
        return productCategoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) productCategoryRepository.findAll();
    }
    @Override
    public Category findById(long id) {
        return (Category) productCategoryRepository.findById(id).orElse(null);
    }
}
