package savvycom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvycom.productservice.domain.entity.Image;
import savvycom.productservice.service.IImageService;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {
    private IImageService imageService;

    @Autowired
    public ImageController(IImageService ImageService){
        this.imageService=ImageService;
    }
    @GetMapping("")
    public List<Image> findAll() {
        return imageService.findAll();
    }
    @GetMapping("/{id}")
    public Image findById(@PathVariable long id) {
        return imageService.findById(id);
    }
}
