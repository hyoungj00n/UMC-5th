package study.web.controller;


import javax.validation.Valid;

//import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.base.ApiResponse;
import study.converter.MemberConverter;
import study.converter.MemberMissionConverter;
import study.domain.Member;
import study.domain.Mission;
import study.domain.mapping.MemberMission;
import study.service.MemberService.MemberCommandService;
import study.service.MemberService.MemberQueryService;
import study.web.dto.MemberResponseDTO;
import study.web.dto.MemberRequestDTO;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    private final MemberQueryService memberQueryService;
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

    @GetMapping("/{memberId}/missions/")
    public ApiResponse<MemberResponseDTO.MemberMissionListDTO> getMissionList(@PathVariable(name = "memberId") Long memberId,
                                                                                @RequestParam(name = "page") Integer page){

        memberQueryService.getMissionList(memberId,page);
        return null;
    }

    @PutMapping("/{memberId}/mission/{missionId}")
    public ApiResponse<MemberResponseDTO.MemberMissionDTO> putMissionCheck(@PathVariable(name = "memberId") Long memberId,
                                                                           @PathVariable(name = "missionId") Long missionId){

        memberCommandService.checkMemberMission(memberId,missionId);
        return null;
    }

}
