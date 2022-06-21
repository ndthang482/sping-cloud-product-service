package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.dto.ProductDTO;
import savvycom.productservice.domain.entity.product.Product;
import savvycom.productservice.repository.product.ProductRepository;
import savvycom.productservice.service.product.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Override
    public void delete(Long id) {
        Product product= productRepository.findById(id).orElse(null);
        if(product != null){
            product.setActive(0);
            save(product);
        }

    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Product findById(long id) {
        return (Product) productRepository.findById(id).orElse(null);
    }
    @Override
    public List<ProductDTO> findProductDTOById(Long id){
        return productRepository.findById(id).stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
