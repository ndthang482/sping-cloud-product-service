package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.Image;
import savvycom.productservice.repository.ImageRepository;
import savvycom.productservice.service.IImageService;

import java.util.List;

@Service
public class ImageService implements IImageService {
    private ImageRepository imageRepository;
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<Image> findAll() {
        return (List<Image>) imageRepository.findAll();
    }
    @Override
    public Image findById(long id) {
        return (Image) imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image findByProductId(int product_id) {
        return (Image) imageRepository.findByProductId(product_id).orElse(null);
    }
}
