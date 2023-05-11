package reviews.service;

import exceptions.ConflictException;
import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.model.Product;
import product.repository.ProductRepository;
import reviews.dto.CreateReviewDto;
import reviews.dto.ReviewFullDto;
import reviews.mapper.ReviewMapper;
import reviews.model.Review;
import reviews.repository.ReviewsRepository;
import user.model.User;
import user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReviewServiceImpl implements ReviewService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ReviewsRepository reviewsRepository;

    @Override
    public ReviewFullDto create(CreateReviewDto createReviewDto, Long userId, Long productId) {
        User user = checkUser(userId);
        Product product = checkProduct(productId);
        Review review = reviewsRepository.save(ReviewMapper.toReviewFromCreate(createReviewDto, product, user));
        return ReviewMapper.toReviewFull(review);
    }

    @Override
    public ReviewFullDto update(CreateReviewDto createReviewDto, Long userId, Long reviewId) {
        checkUser(userId);
        Review review = checkReview(reviewId);
        if (review.getCreator().getId() != userId) {
            throw new ConflictException("Нельзя редактировать чужие комментарии");
        }
        if (createReviewDto.getCreator() != null && createReviewDto.getCreator() != userId) {
            throw new ConflictException("Creator и userId отличаются");
        }
        if (createReviewDto.getDescription() != null) {
            review.setDescription(createReviewDto.getDescription());
        }
        return ReviewMapper.toReviewFull(review);
    }

    @Override
    public List<ReviewFullDto> findByOwner(Long userId) {
        checkUser(userId);
        return reviewsRepository.findByOwner(userId).stream()
                .map(ReviewMapper::toReviewFull)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByOwner(Long userId, Long reviewId) {
        checkUser(userId);
        Review review = checkReview(reviewId);
        if (review.getCreator().getId() != userId) {
            throw new ConflictException("Нельзя удалять чужие комментарии");
        }
        reviewsRepository.deleteById(reviewId);
    }

    @Override
    public List<ReviewFullDto> findByProduct(Long userId, Long productId) {
        checkUser(userId);
        checkProduct(productId);
        return reviewsRepository.findByProduct(productId).stream()
                .map(ReviewMapper::toReviewFull)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByAdmin(Long reviewId) {
        checkReview(reviewId);
        reviewsRepository.deleteById(reviewId);
    }

    @Override
    public List<ReviewFullDto> getByUser(Long userId) {
        checkUser(userId);
        return reviewsRepository.findByOwner(userId).stream()
                .map(ReviewMapper::toReviewFull)
                .collect(Collectors.toList());
    }

    private User checkUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new NotFoundException("Пользователь не найден");
        });
    }

    private Review checkReview(Long reviewId) {
        return reviewsRepository.findById(reviewId).orElseThrow(() -> {
            throw new NotFoundException("Отзыв не найден");
        });
    }

    private Product checkProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> {
            throw new NotFoundException("Продукт не найден");
        });
    }
}
