package savvycom.productservice.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvycom.productservice.domain.entity.product.ProductInventory;
import savvycom.productservice.service.product.IProductInventoryService;

import java.util.List;

@RestController
@RequestMapping("/product/inventory")
public class ProductInventoryController {
    private IProductInventoryService productInventoryService;

    @Autowired
    public ProductInventoryController(IProductInventoryService ProductInventoryService) {
        this.productInventoryService = ProductInventoryService;
    }

    @GetMapping("")
    public List<ProductInventory> findAll() {
        return productInventoryService.findAll();
    }

    @GetMapping("/{id}")
    public ProductInventory findById(@PathVariable long id) {
        return productInventoryService.findById(id);
    }
}