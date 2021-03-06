package savvycom.productservice.service.impl;
//@Service hold the business handling code in it

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.model.entity.product.Inventory;
import savvycom.productservice.repository.product.InventoryRepository;
import savvycom.productservice.service.product.IInventoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService implements IInventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }


    @Override
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory findById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inventory> fineAllBranchByInventory(Long branchId) {
        return inventoryRepository.findAll().stream()
                .filter(inventory -> inventory.getBranchId() == branchId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Inventory> findAllProductByInventory(Long productId) {
        return inventoryRepository.findAll().stream()
                .filter(inventory -> inventory.getProductId() == productId)
                .collect(Collectors.toList());
    }
}