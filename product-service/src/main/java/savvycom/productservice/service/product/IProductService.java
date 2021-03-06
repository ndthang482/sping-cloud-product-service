package savvycom.productservice.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import savvycom.productservice.domain.model.dto.ProductResponse;
import savvycom.productservice.domain.model.entity.product.Product;
import savvycom.productservice.domain.model.dto.ProductOutput;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IProductService {
    Product save(Product product);
    void delete(Long id);
    Product findById(Long id);

//    List<ProductDTO> findProductDTOById(Long id);

   List<ProductOutput> findProductByProductLine(Long productLineId);

    ProductOutput findProductOutputById(Long id);

//    Page<ProductOutput> findAll();

    //price
    List<Product> findByPriceLess1M(BigDecimal price);

    List<ProductOutput> findProductPriceLess1M(BigDecimal price);
    List<Product> findByPriceLess3M(BigDecimal price);
    List<ProductOutput> findByPriceBetween1And3M(BigDecimal price);
    List<Product> findByPriceAbove3M(BigDecimal price);
    List<ProductOutput> findByPriceAbove3Million(BigDecimal price);

    //optional
    List<ProductOutput> findColorByProductDTO(String color);

    List<Product> findProductByColor(String color);

    List<Product> findProductBySize(String size);

    List<ProductOutput> findSizeByProductDTO(String size);

    List<ProductOutput> findByDiscountUnder30(Long discountId);

    List<ProductOutput> findByDiscount30to50(Long discountId);

    List<ProductOutput> findByDiscountAbove50(Long discountId);

    ProductResponse findAllResponse(int pageNo, int pageSize, String sortBy, String sortDir);

    ProductResponse findAllByProductLineIds(List<Long> productLineIds, int pageNo, int pageSize, String sortBy, String sortDir );

}


