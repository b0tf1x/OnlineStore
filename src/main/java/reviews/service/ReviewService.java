package reviews.service;

import reviews.dto.CreateReviewDto;
import reviews.dto.ReviewFullDto;

import java.util.List;

public interface ReviewService {
    ReviewFullDto create(CreateReviewDto createReviewDto, Long userId, Long productId);
    ReviewFullDto update(CreateReviewDto createReviewDto, Long userId, Long reviewId);
    List<ReviewFullDto>findByOwner(Long userId);
    void deleteByOwner(Long userId, Long reviewId);
    List<ReviewFullDto>findByProduct(Long userId, Long productId);
    void deleteByAdmin(Long reviewId);
    List<ReviewFullDto>getByUser(Long userId);
}
