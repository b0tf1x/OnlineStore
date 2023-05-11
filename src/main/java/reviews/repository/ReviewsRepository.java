package reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reviews.model.Review;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Review, Long> {
    @Query("select review from Review review " +
            "where review.creator = ?1 ")
    List<Review> findByOwner(Long userId);

    @Query("select review from Review review " +
            "where review.product = ?1 ")
    List<Review> findByProduct(Long productId);
}
