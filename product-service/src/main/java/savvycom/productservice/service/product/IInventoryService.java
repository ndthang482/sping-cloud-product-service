package savvycom.productservice.service.product;

import savvycom.productservice.domain.entity.product.Inventory;

import java.util.List;

public interface IInventoryService {
    Inventory save(Inventory Inventory);

    void delete(Long id);

    List<Inventory> findAll();

    Inventory findById(Long id);

    List<Inventory> fineAllBranchByInventory(Long branchId);

    List<Inventory> findAllProductByInventory(Long productId);
}