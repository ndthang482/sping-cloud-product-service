package savvycom.productservice.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import savvycom.productservice.domain.dto.ProductDTO;
import savvycom.productservice.domain.entity.product.Product;
import savvycom.productservice.repository.product.ProductRepository;
import savvycom.productservice.service.product.IProductService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {
    private IProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductController(IProductService ProductService) {
        this.productService = ProductService;
    }

    @GetMapping()
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return productService.findById(id);
    }

    @GetMapping("/dto/{id}")
    public List<ProductDTO> findProductDTOById(@PathVariable("id") Long id) {
        return productService.findProductDTOById(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.delete(id);
    }
    @PostMapping("/create")
    public Product createProduct(@PathVariable(value = "categoryId") Long categoryId,
                                 @PathVariable(value = "supermarketId") Long supermarketId, @Valid @RequestBody Product product) {
        product.setCategory(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId)));
        product.setSupermarket(supermarketRepository.findById(supermarketId)
                .orElseThrow(() -> new ResourceNotFoundException("Supermarket not found with id " + supermarketId)));
        return productRepository.save(product);
    }
    @PostMapping("/save")
    public Product save(Product product){
        return productService.save(product);
    }
}
