package aims.repository;

import aims.model.Aim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AimsRepository extends JpaRepository<Aim, Long> {
}
