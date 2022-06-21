package savvycom.productservice.service.impl;
import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.product.ProductInventory;
import savvycom.productservice.repository.product.ProductInventoryRepository;
import savvycom.productservice.service.product.IProductInventoryService;

import java.util.List;

@Service
public class ProductInventoryService implements IProductInventoryService {
    private ProductInventoryRepository productInventoryRepository;

    public ProductInventoryService(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }

    @Override
    public ProductInventory save(ProductInventory productInventory) {
        return productInventoryRepository.save(productInventory);
    }


    @Override
    public void delete(Long id) {
        productInventoryRepository.deleteById(id);
    }

    @Override
    public List<ProductInventory> findAll() {
        return (List<ProductInventory>) productInventoryRepository.findAll();
    }
    @Override
    public ProductInventory findById(long id) {
        return (ProductInventory) productInventoryRepository.findById(id).orElse(null);
    }
}