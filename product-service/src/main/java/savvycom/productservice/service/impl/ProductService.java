package savvycom.productservice.service.impl;
//@Service hold the business handling code in it

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import savvycom.productservice.domain.model.dto.ProductResponse;
import savvycom.productservice.domain.model.entity.product.Product;
import savvycom.productservice.domain.model.dto.ProductOutput;
import savvycom.productservice.repository.product.ProductRepository;
import savvycom.productservice.service.IImageService;
import savvycom.productservice.service.product.IProductLineService;
import savvycom.productservice.service.product.IProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
//class ProductService implements to interface IProductService
//bắt buộc rằng productService phải override all interface IProductService

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    //nâng cấp của bean(khi không biết nó có chứa cái kia hay cái kia chứa nó)
    @Autowired
    private IImageService imageService;

    @Autowired
    private IProductLineService productLineService;



    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Override: ghi đè phương thức(nếu lớp con có phương thức giống lớp cha)
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    //delete set(active)
    @Override
    public void delete(Long id) {
        Product product= productRepository.findById(id).orElse(null);
        if(product != null){
            product.setActive(0L);
            save(product);
        }

    }

    //find id by product
    //Override: ghi đè phương thức (khi interface business service bắt buộc phải ovverride trong class)

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    //find display id, price in Product to ProductDTO

//    @Override
//    public List<ProductDTO> findProductDTOById(Long id){
//        return productRepository.findById(id).stream().map(ProductDTO::new).collect(Collectors.toList());
//    }

    //find all line by product

    @Override
    public List<ProductOutput> findProductByProductLine(Long productLineId) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getProductLineId() == productLineId)
                .collect(Collectors.toList());
    }



    //productOutput được dựng lên và trả về Id của từng productOutput
    @Override
    public ProductOutput findProductOutputById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return ProductOutput.builder()
                .id(product.getId())
                .color(product.getColor())
                .size(product.getSize())
                .productLineId(product.getProductLineId())
                .price(product.getPrice())
                .discountId(product.getDiscountId())
                .active(product.getActive())
                .images(imageService.findByProductId(product.getId()))
                .created_at(product.getCreatedAt())
                .modified_at(product.getModifiedAt())
                .build();
    }


    private ProductOutput mapToDTO(Product product){
        ProductOutput productOutput = new ProductOutput();
        productOutput.setId(product.getId());
        productOutput.setProductLineId(product.getProductLineId());
        productOutput.setColor(product.getColor());
        productOutput.setSize(product.getSize());
        productOutput.setImages(imageService.findByProductId(product.getId()));
        productOutput.setPrice(product.getPrice());
        productOutput.setActive(product.getActive());
        productOutput.setDiscountId(product.getDiscountId());
        productOutput.setCreated_at(product.getCreatedAt());
        productOutput.setModified_at(product.getModifiedAt());
        return productOutput;
    }

    private Product mapToEntity(ProductOutput productOutput){
        Product product = new Product();
        product.setColor(productOutput.getColor());
        product.setSize(productOutput.getSize());
        product.setProductLineId(productOutput.getProductLineId());
        product.setPrice(productOutput.getPrice());
        product.setDiscountId(productOutput.getDiscountId());
        product.setActive(productOutput.getActive());
        product.setCreatedAt(productOutput.getCreated_at());
        product.setModifiedAt(productOutput.getModified_at());
        return product;
    }
    //map productOutputById find all productOutput (ProductImage)
    @Override
    public ProductResponse findAllResponse(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> products = productRepository.findAll(pageable);

        List<Product> ListOfProducts = products.getContent();

        List<ProductOutput> content = ListOfProducts.stream().map(product -> mapToDTO(product))
                .collect(Collectors.toList());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(content);
        productResponse.setPageNo(products.getNumber());
        productResponse.setPageSize(products.getSize());
        productResponse.setTotalElements(products.getTotalElements());
        productResponse.setTotalPages(products.getTotalPages());
        productResponse.setLast(products.isLast());

        return productResponse;
    }

    @Override
    public ProductResponse findAllByProductLineIds(List<Long> productLineIds, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> products = productRepository.findByProductLineIdIn(productLineIds,
                PageRequest.of(pageNo, pageSize, sort));
        List<ProductOutput> content = products.getContent().stream()
                .map(product -> mapToDTO(product)).collect(Collectors.toList());
        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(content);
        productResponse.setPageNo(products.getNumber());
        productResponse.setPageSize(products.getSize());
        productResponse.setTotalElements(products.getTotalElements());
        productResponse.setTotalPages(products.getTotalPages());
        productResponse.setLast(products.isLast());

        return productResponse;
    }

    @Override
    public List<Product> findByPriceLess1M(BigDecimal price) {
        return productRepository.findByPriceLess1M(price);
    }
    @Override
    public List<ProductOutput> findProductPriceLess1M(BigDecimal price) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByPriceLess3M(BigDecimal price) {
        return productRepository.findByPriceLess3M(price);
    }
    @Override
    public List<ProductOutput> findByPriceBetween1And3M(BigDecimal price) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByPriceAbove3M(BigDecimal price) {
        return productRepository.findByPriceAbove3M(price);
    }

    @Override
    public List<ProductOutput> findByPriceAbove3Million(BigDecimal price) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductOutput> findColorByProductDTO(String color){
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getColor() == color)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductByColor(String color) {
        return productRepository.findProductByColor(color);
    }

    @Override
    public List<Product> findProductBySize(String size) {
        return productRepository.findProductBySize(size);
    }

    @Override
    public List<ProductOutput> findSizeByProductDTO(String size) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getSize()== size)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductOutput> findByDiscountUnder30(Long discountId) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getDiscountId()== discountId)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductOutput> findByDiscount30to50(Long discountId) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getDiscountId()== discountId)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductOutput> findByDiscountAbove50(Long discountId) {
        return productRepository.findAll().stream()
                .map(product -> ProductOutput.builder()
                        .id(product.getId())
                        .color(product.getColor())
                        .size(product.getSize())
                        .productLineId(product.getProductLineId())
                        .price(product.getPrice())
                        .discountId(product.getDiscountId())
                        .active(product.getActive())
                        .images(imageService.findByProductId(product.getId()))
                        .created_at(product.getCreatedAt())
                        .modified_at(product.getModifiedAt())
                        .build())
                .filter(product -> product.getDiscountId()== discountId)
                .collect(Collectors.toList());
    }

}
