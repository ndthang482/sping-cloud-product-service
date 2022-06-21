package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.product.ProductLine;
import savvycom.productservice.repository.product.ProductLineRepository;
import savvycom.productservice.service.product.IProductLineService;

import java.util.List;

@Service
public class ProductLineService implements IProductLineService {
    private ProductLineRepository productLineRepository;

    public ProductLineService(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    @Override
    public ProductLine save(ProductLine productLine) {
        return productLineRepository.save(productLine);
    }

    @Override
    public void delete(Long id) {
        productLineRepository.deleteById(id);
    }

    @Override
    public List<ProductLine> findAll() {
        return (List<ProductLine>) productLineRepository.findAll();
    }
    @Override
    public ProductLine findById(long id) {
        return (ProductLine) productLineRepository.findById(id).orElse(null);
    }
}
