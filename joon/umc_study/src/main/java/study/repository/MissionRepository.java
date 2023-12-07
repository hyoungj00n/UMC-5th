package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission,Long> {
}
