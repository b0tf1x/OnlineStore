package reviews.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reviews.dto.ReviewFullDto;
import reviews.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/admin/reviews/")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminReviewsController {
    private final ReviewService reviewService;

    @DeleteMapping("/{reviewId}")
    public void deleteByAdmin(@PathVariable Long reviewId) {
        reviewService.deleteByAdmin(reviewId);
    }

    @GetMapping("/user/{userId}")
    public List<ReviewFullDto> getByUser(@PathVariable Long userId) {
        return reviewService.getByUser(userId);
    }
}
