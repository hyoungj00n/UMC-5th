package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Store;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
