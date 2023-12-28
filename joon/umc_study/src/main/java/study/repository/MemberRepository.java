package study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Review;
import study.domain.Store;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Page<Mission> findMissionById(long memberId,PageRequest pageRequest);

}
