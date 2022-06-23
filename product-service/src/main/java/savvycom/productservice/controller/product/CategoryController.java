package savvycom.productservice.controller.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import savvycom.productservice.domain.entity.product.Category;
import savvycom.productservice.service.product.IProductCategoryService;

import java.util.List;


@RestController
@RequestMapping("/category")
public class ProductCategoryController {
    private IProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(IProductCategoryService ProductCategoryService){
        this.productCategoryService=ProductCategoryService;
    }
    @GetMapping("")
    public List<Category> findAll() {
        return productCategoryService.findAll();
    }
    @PostMapping("")
    public Category newCategory(@RequestBody Category category){
        return productCategoryService.save(category);
    }
    @GetMapping("/{id}")
    public Category findById(@PathVariable long id) {
        return productCategoryService.findById(id);
    }

    @PutMapping("{id}")
    public Category updateCategory(@RequestBody Category category){
        return productCategoryService.save(category);
    }
}
