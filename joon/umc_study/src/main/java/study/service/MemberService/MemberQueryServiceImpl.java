package study.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Member;
import study.domain.Mission;
import study.repository.MemberRepository;
import study.repository.MissionRepository;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;
    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Mission> getMissionList(Long id, Integer page) {
        Member member = memberRepository.findById(id).get();

        Page<Mission> MissionList = missionRepository.findAllByMember(member, PageRequest.of(page,10));

        return MissionList;
    }
}