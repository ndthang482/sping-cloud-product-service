package savvycom.productservice.service;

import savvycom.productservice.domain.entity.Image;

import java.util.List;

public interface IImageService {
    Image save(Image image);

    void delete(Long id);

    List<Image> findAll();

    Image findById(Long id);

    List<Image> findByProductId(Long productId);

}
