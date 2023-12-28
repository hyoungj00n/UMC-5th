package study.service.MemberService;

import org.springframework.data.domain.Page;
import study.domain.Member;
import study.domain.Mission;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    public Page<Mission> getMissionList(Long memberId, Integer page);



}
