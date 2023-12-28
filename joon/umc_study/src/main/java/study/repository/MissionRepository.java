package study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Review;
import study.domain.Store;
import study.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission,Long> {


}
