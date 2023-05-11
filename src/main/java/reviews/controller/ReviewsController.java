package reviews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reviews.dto.CreateReviewDto;
import reviews.dto.ReviewFullDto;
import reviews.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews/{userId}")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ReviewsController {
    private final ReviewService reviewService;

    @PostMapping("/product/{productId}")
    public ReviewFullDto create(@RequestBody @Validated CreateReviewDto createReviewDto,
                                @PathVariable Long userId, @PathVariable Long productId) {
        return reviewService.create(createReviewDto, userId, productId);
    }

    @PatchMapping("/comment/{commentId}")
    public ReviewFullDto update(@RequestBody @Validated CreateReviewDto createReviewDto,
                                @PathVariable Long userId, @PathVariable Long commentId) {
        return reviewService.update(createReviewDto, userId, commentId);
    }

    @GetMapping
    public List<ReviewFullDto> findByOwner(@PathVariable Long userId) {
        return reviewService.findByOwner(userId);
    }

    @DeleteMapping("/delete/{reviewId}")
    public void deleteByOwner(@PathVariable Long userId, @PathVariable Long reviewId) {
        reviewService.deleteByOwner(userId, reviewId);
    }

    @GetMapping("/product/{productId}")
    public List<ReviewFullDto> findByProduct(@PathVariable Long userId, @PathVariable Long productId) {
        return reviewService.findByProduct(userId, productId);
    }
}
