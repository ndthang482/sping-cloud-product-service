package savvycom.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import savvycom.productservice.domain.model.ProductOutput;
import savvycom.productservice.domain.entity.Image;
import savvycom.productservice.service.IImageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController extends BaseController{
    private IImageService imageService;

    @Autowired
    public ImageController(IImageService ImageService){
        this.imageService=ImageService;
    }

    //find all image

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return successResponse(imageService.findAll());
    }

    //find id by image

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return successResponse(imageService.findById(id));
    }

}
