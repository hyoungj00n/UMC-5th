package study.service.MemberService;

import study.domain.Member;
import study.domain.mapping.MemberMission;
import study.web.dto.MemberRequestDTO;

import java.util.Optional;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);

    public Member joinMemberMission(Long memberId, Long missionId);


}
