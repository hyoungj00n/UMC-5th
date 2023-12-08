package study.web.controller;


import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.base.ApiResponse;
import study.converter.MemberConverter;
import study.domain.Member;
import study.domain.mapping.MemberMission;
import study.service.MemberService.MemberCommandService;
import study.web.dto.MemberResponseDTO;
import study.web.dto.MemberRequestDTO;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/{memberId}/mission/{missionId}")
    public ApiResponse<MemberResponseDTO.MemberMissionDTO> joinMission(@PathVariable(name = "memberId") Long memberId,
                                                                       @PathVariable(name = "missionId") Long missionId
    ){
        Member member = memberCommandService.joinMemberMission(memberId,missionId);
        return ApiResponse.onSuccess(MemberConverter.toJoinMissionResultDTO(member));
    }
}
