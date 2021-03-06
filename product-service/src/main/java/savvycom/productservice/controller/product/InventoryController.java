package savvycom.productservice.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import savvycom.productservice.controller.BaseController;
import savvycom.productservice.domain.model.entity.product.Inventory;
import savvycom.productservice.service.product.IInventoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryController extends BaseController {
    private IInventoryService inventoryService;
    @Autowired
    public InventoryController(IInventoryService InventoryService) {
        this.inventoryService = InventoryService;
    }

    //find all ịnventory

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return successResponse(inventoryService.findAll());
    }

    //Pos create a create inventory

    @PostMapping("")
    public ResponseEntity<?> newInventory(@RequestBody Inventory inventory){
        return successResponse(inventoryService.save(inventory));
    }

    //find id by inventory

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return successResponse(inventoryService.findById(id));
    }

    //Put: update inventory

    @PutMapping("{id}")
    public ResponseEntity<?> updateInventory(@RequestBody Inventory inventory){
        return successResponse(inventoryService.save(inventory));
    }

    //find all branch by inventory

    @GetMapping("/branch/{id}")
    public ResponseEntity<?> findAllBranchByInventory(@PathVariable("id") Long id){
        return successResponse(inventoryService.fineAllBranchByInventory(id));
    }

    //find all product by inventory

    @GetMapping("/product/{id}")
    public ResponseEntity<?> findAllProductByInventory(@PathVariable("id") Long id){
        return successResponse(inventoryService.findAllProductByInventory(id));
    }
}