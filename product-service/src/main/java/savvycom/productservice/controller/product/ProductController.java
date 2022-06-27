package savvycom.productservice.controller.product;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import savvycom.productservice.controller.BaseController;
import savvycom.productservice.domain.model.dto.ProductResponse;
import savvycom.productservice.domain.model.entity.Discount;
import savvycom.productservice.domain.model.entity.product.Product;
import savvycom.productservice.domain.model.entity.product.ProductLine;
import savvycom.productservice.domain.model.dto.ProductOutput;
import savvycom.productservice.service.IDiscountService;
import savvycom.productservice.service.product.IProductLineService;
import savvycom.productservice.service.product.IProductService;
import savvycom.productservice.utils.AppConstants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductLineService productLineService;

    @Autowired
    private IDiscountService discountService;

    @Autowired
    public ProductController(IProductService ProductService) {
        this.productService = ProductService;
    }

    @PostMapping()
    @Operation(summary = "Create new product")
    public ResponseEntity<?> newProduct(@RequestBody Product product) {
        return successResponse(productService.save(product));
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete product by admin")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    @PutMapping("{id}")
    @Operation(summary = "Update product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return successResponse(productService.save(product));
    }
    @GetMapping("/line/{id}")
    @Operation(summary = "Find Product by ProductLine")
    public ResponseEntity<?> findProductByProductLine(@PathVariable("id") Long id) {
        return successResponse(productService.findProductByProductLine(id));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find ProductOutput By id")
    public ResponseEntity<?> findProductOutputById(@PathVariable("id") Long id){
        return successResponse(productService.findProductOutputById(id));
    }
    @GetMapping("")
    @Operation(summary = "Find all product")
    public ResponseEntity<?>  findAllProductResponse(
    @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
    @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
    @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
    @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir)
    {
        return successResponse(productService.findAllResponse(pageNo, pageSize, sortBy, sortDir));
    }

    @GetMapping("/search")
    @Operation(summary = "Search name Product By ProductLine")
    public ResponseEntity<?> findByNameLike(@RequestParam String name,
                                            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir)
    {
        name = "%" + name + "%";
        List<ProductLine> productLines = productLineService.findByNameLike(name);
        List<Long> productLineIds = productLines.stream().map(productLine -> productLine.getId()).collect(Collectors.toList());
        ProductResponse productResponse = productService.findAllByProductLineIds(productLineIds, pageNo, pageSize, sortBy, sortDir);
        return successResponse(productResponse);
    }
    @GetMapping("/search/1M")
    @Operation(summary = "Search name Product By ProductLine")
    public ResponseEntity<?> findByPriceLess1M(@RequestParam BigDecimal q){
        List<Product> products = productService.findByPriceLess1M(q);
        List<ProductOutput> productOutputs = new ArrayList<>();
        for(Product product : products){
                productOutputs.addAll(productService.findProductPriceLess1M(product.getPrice()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/3M")
    public ResponseEntity<?> findByPriceLess3M(@RequestParam BigDecimal q){
        List<Product> products = productService.findByPriceLess3M(q);
        List<ProductOutput> productOutputs = new ArrayList<>();
        for(Product product : products){
            productOutputs.addAll(productService.findByPriceBetween1And3M(product.getPrice()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/above3")
    public ResponseEntity<?> findByPriceAbove3M(@RequestParam BigDecimal q){
        List<Product> products = productService.findByPriceAbove3M(q);
        List<ProductOutput> productOutputs = new ArrayList<>();
        for(Product product : products){
            productOutputs.addAll(productService.findByPriceAbove3Million(product.getPrice()));
        }
        return successResponse(productOutputs);
    }

    @GetMapping("/search/size")
    public ResponseEntity<?> findBySizeLike(@RequestParam String s){

        List<Product> products = productService.findProductBySize(s);

        List<ProductOutput> productOutputs = new ArrayList<>();

        for (Product product : products) {
            productOutputs.addAll(productService.findSizeByProductDTO(product.getSize()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/color")
    public ResponseEntity<?> findByColorLike(@RequestParam String q){

        List<Product> products = productService.findProductByColor(q);

        List<ProductOutput> productOutputs = new ArrayList<>();

        for (Product product : products) {
            productOutputs.addAll(productService.findColorByProductDTO(product.getColor()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/under30")
    public ResponseEntity<?> findByDiscountUnder30(@RequestParam String q){

        List<Discount> discounts = discountService.findByDiscountUnder30(q);
        List<ProductOutput> productOutputs = new ArrayList<>();

        for (Discount discount : discounts) {
            productOutputs.addAll(productService.findByDiscountUnder30(discount.getId()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/30to50")
    public ResponseEntity<?> findByDiscount30to50(@RequestParam String q){

        List<Discount> discounts = discountService.findByDiscount30to50(q);
        List<ProductOutput> productOutputs = new ArrayList<>();

        for (Discount discount : discounts) {
            productOutputs.addAll(productService.findByDiscount30to50(discount.getId()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/above70")
    public ResponseEntity<?> findByDiscountAbove50(@RequestParam String q){

        List<Discount> discounts = discountService.findByDiscountAbove50(q);
        List<ProductOutput> productOutputs = new ArrayList<>();

        for (Discount discount : discounts) {
            productOutputs.addAll(productService.findByDiscountAbove50(discount.getId()));
        }
        return successResponse(productOutputs);
    }

}
