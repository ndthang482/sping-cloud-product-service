package savvycom.productservice.service.impl;

import org.springframework.stereotype.Service;
import savvycom.productservice.domain.entity.Review;
import savvycom.productservice.repository.ReviewRepository;
import savvycom.productservice.service.IReviewService;

import java.util.List;

@Service
public class ReviewService implements IReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Review> findAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review findById(long id) {
        return (Review) reviewRepository.findById(id).orElse(null);
    }


}
