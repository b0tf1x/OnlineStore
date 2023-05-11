package reviews.mapper;

import product.model.Product;
import reviews.dto.CreateReviewDto;
import reviews.dto.ReviewFullDto;
import reviews.model.Review;
import user.model.User;

public class ReviewMapper {
    public static Review toReviewFromCreate(CreateReviewDto createReviewDto, Product product, User creator) {
        return new Review(createReviewDto.getId(),
                product,
                creator,
                createReviewDto.getDescription(),
                createReviewDto.getDate());
    }

    public static ReviewFullDto toReviewFull(Review review) {
        return new ReviewFullDto(review.getId(),
                review.getProduct(),
                review.getCreator(),
                review.getDescription(),
                review.getDate());
    }
}
