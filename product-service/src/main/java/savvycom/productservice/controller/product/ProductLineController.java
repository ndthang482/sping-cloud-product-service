package savvycom.productservice.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import savvycom.productservice.domain.entity.product.ProductLine;
import savvycom.productservice.service.product.IProductLineService;


import java.util.List;

@RestController
@RequestMapping("/product/line")
public class ProductLineController {
    private IProductLineService productLineService;

    @Autowired
    public ProductLineController(IProductLineService ProductLineService){
        this.productLineService=ProductLineService;
    }
    @GetMapping("")
    public List<ProductLine> findAll() {
        return productLineService.findAll();
    }
    @GetMapping("/{id}")
    public ProductLine findById(@PathVariable long id) {
        return productLineService.findById(id);
    }

}
