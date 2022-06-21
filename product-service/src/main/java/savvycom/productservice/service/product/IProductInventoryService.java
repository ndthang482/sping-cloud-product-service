package savvycom.productservice.service.product;

import savvycom.productservice.domain.entity.product.ProductInventory;

import java.util.List;

public interface IProductInventoryService {
    ProductInventory save(ProductInventory ProductInventory);

    void delete(Long id);

    List<ProductInventory> findAll();

    ProductInventory findById(long id);
}