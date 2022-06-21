package savvycom.productservice.controller.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import savvycom.productservice.domain.entity.product.ProductCategory;
import savvycom.productservice.service.product.IProductCategoryService;

import java.util.List;


@RestController
@RequestMapping("/product/category")
public class ProductCategoryController {
    private IProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(IProductCategoryService ProductCategoryService){
        this.productCategoryService=ProductCategoryService;
    }
    @GetMapping("")
    public List<ProductCategory> findAll() {
        return productCategoryService.findAll();
    }
    @GetMapping("/{id}")
    public ProductCategory findById(@PathVariable long id) {
        return productCategoryService.findById(id);
    }
}
