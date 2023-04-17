package aims.repository;

import aims.model.Aim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AimsRepository extends JpaRepository<Aim, Long> {
}
