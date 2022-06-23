package savvycom.productservice.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import savvycom.productservice.domain.entity.product.Inventory;
import savvycom.productservice.service.product.IProductInventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductInventoryController {
    private IProductInventoryService productInventoryService;

    @Autowired
    public ProductInventoryController(IProductInventoryService ProductInventoryService) {
        this.productInventoryService = ProductInventoryService;
    }

    @GetMapping("")
    public List<Inventory> findAll() {
        return productInventoryService.findAll();
    }
    @PostMapping("")
    public Inventory newInventory(@RequestBody Inventory inventory){
        return productInventoryService.save(inventory);
    }

    @GetMapping("/{id}")
    public Inventory findById(@PathVariable long id) {
        return productInventoryService.findById(id);
    }
    @PutMapping("{id}")
    public Inventory updateInventory(@RequestBody Inventory inventory){
        return productInventoryService.save(inventory);
    }
}