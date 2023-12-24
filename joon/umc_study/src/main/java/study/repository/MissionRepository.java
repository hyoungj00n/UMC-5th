package study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Review;
import study.domain.Store;

public interface MissionRepository extends JpaRepository<Mission,Long> {

    Page<Mission> findAllByMember(Member member, PageRequest pageRequest);
}
