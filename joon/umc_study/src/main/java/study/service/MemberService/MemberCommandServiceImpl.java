package study.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.ErrorState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.base.Code;
import study.base.exception.handler.FoodCategoryHandler;
import study.converter.MemberConverter;
import study.converter.MemberPreferConverter;
import study.domain.FoodCategory;
import study.domain.Member;
import study.domain.mapping.MemberPrefer;
import study.repository.FoodCategoryRepository;
import study.repository.MemberRepository;
import study.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category ->{
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(Code.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);

    }
}
