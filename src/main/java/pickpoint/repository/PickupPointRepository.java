package pickpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pickpoint.model.PickupPoint;

@Repository

public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {
}
