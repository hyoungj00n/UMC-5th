package study.service.MemberService;

import study.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

}
