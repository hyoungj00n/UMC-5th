package study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.converter.MemberConverter;
import study.converter.MemberMissionConverter;
import study.converter.ReviewConverter;
import study.converter.MissionConverter;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Review;
import study.domain.mapping.MemberMission;
import study.repository.MemberRepository;
import study.repository.MissionRepository;
import study.repository.ReviewRepository;
import study.repository.StoreRepository;
import study.web.dto.StoreRequestDTO;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    @Override
    public Review createReview(Long storeId, Long memberId, StoreRequestDTO.ReviewDTO request) {

        Review review  = ReviewConverter.toReview(request);
        review.setStore(storeRepository.findById(storeId).get());
        review.setMember(memberRepository.findById(memberId).get());

        return reviewRepository.save(review);

    }

    @Override
    public Mission createMission(Long memberId, Long storeId, StoreRequestDTO.MissionDTO request){

        Mission mission = MissionConverter.toMission(request);

        List<Member> memberList = MemberConverter.toMemberList(request,memberRepository);

        List<MemberMission> memberMissionList = MemberMissionConverter.toMemberMission(memberList);

        memberMissionList.forEach(memberMission -> {memberMission.setMission(mission);});

        return missionRepository.save(mission);

    }
}
