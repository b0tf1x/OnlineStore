package pickpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pickpoint.model.PickupPoint;

public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {
}
