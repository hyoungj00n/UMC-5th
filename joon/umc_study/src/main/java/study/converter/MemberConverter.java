package study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.base.ErrorStatus;
import study.base.exception.handler.FoodCategoryHandler;
import study.base.exception.handler.MemberMissionHandler;
import study.domain.Member;
import study.domain.enums.Gender;
import study.repository.MemberRepository;
import study.web.dto.MemberRequestDTO;
import study.web.dto.MemberResponseDTO;
import study.web.dto.StoreRequestDTO;

import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MemberConverter {



    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .age(request.getAge())
                .memberPreferList(new ArrayList<>())
                .build();
    }



    public static List<Member> toMemberList(StoreRequestDTO.MissionDTO request,MemberRepository memberRepository){
        List<Member> memberList = request.getMemberList().stream()
                .map(member -> {
                    return memberRepository.findById(member).orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_NOT_FOUND));
                }).collect(Collectors.toList());
        return memberList;
    }
}
