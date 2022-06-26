package savvycom.productservice.controller.product;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import savvycom.productservice.controller.BaseController;
import savvycom.productservice.domain.entity.Discount;
import savvycom.productservice.domain.entity.product.Product;
import savvycom.productservice.domain.entity.product.ProductLine;
import savvycom.productservice.domain.model.ProductOutput;
import savvycom.productservice.service.IDiscountService;
import savvycom.productservice.service.product.IProductLineService;
import savvycom.productservice.service.product.IProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    //pos: create newproduct by admin

    @PostMapping()
    public ResponseEntity<?> newProduct(@RequestBody Product product) {
        return successResponse(productService.save(product));
    }

    //delete product from by admin

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

    //find id, price in product
//    @GetMapping("/dto/{id}")
//    public ResponseEntity<?> findProductDTOById(@PathVariable("id") Long id) {
//        return successResponse(productService.findProductDTOById(id));
//    }
    // update product
    @PutMapping("{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return successResponse(productService.save(product));
    }

    //find id by product
    @GetMapping("/{id}")
    public ResponseEntity<?> findProductOutputById(@PathVariable("id") Long id){
        return successResponse(productService.findProductOutputById(id));
    }
    //find all product(all ProductImage)
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return successResponse(productService.findAll());
    }

    //find id productline by product

    @GetMapping("/line/{id}")
    public ResponseEntity<?> findProductByProductLine(@PathVariable("id") Long id) {
        return successResponse(productService.findProductByProductLine(id));
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByNameLike(@RequestParam String name) {
        name = "%" + name + "%";
        List<ProductLine> productLines = productLineService.findByNameLike(name);
        List<ProductOutput> productOutputs = new ArrayList<>();
        for(ProductLine productLine : productLines){
            productOutputs.addAll(productService.findProductByProductLine(productLine.getId()));
        }
        return successResponse(productOutputs);
    }
    @GetMapping("/search/1M")
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
