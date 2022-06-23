package savvycom.productservice.service.impl;
import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.product.Inventory;
import savvycom.productservice.repository.product.ProductInventoryRepository;
import savvycom.productservice.service.product.IProductInventoryService;

import java.util.List;

@Service
public class InventoryService implements IProductInventoryService {
    private ProductInventoryRepository productInventoryRepository;

    public InventoryService(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return productInventoryRepository.save(inventory);
    }


    @Override
    public void delete(Long id) {
        productInventoryRepository.deleteById(id);
    }

    @Override
    public List<Inventory> findAll() {
        return (List<Inventory>) productInventoryRepository.findAll();
    }
    @Override
    public Inventory findById(long id) {
        return (Inventory) productInventoryRepository.findById(id).orElse(null);
    }
}