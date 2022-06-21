package savvycom.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import savvycom.productservice.domain.entity.Review;
import savvycom.productservice.repository.ReviewRepository;
import savvycom.productservice.service.IReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private IReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(IReviewService ReviewService) {
        this.reviewService = ReviewService;
    }

    @GetMapping("")
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review findById(@PathVariable long id) {
        return reviewService.findById(id);
    }

}
