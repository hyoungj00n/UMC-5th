package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.base.Code;
import study.base.ResponseDto;
import study.converter.MemberConverter;
import study.domain.Member;
import study.service.MemberService.MemberCommandService;
import study.web.dto.MemberRequestDTO;
import study.web.dto.MemberResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ResponseDto<MemberResponseDTO.JoinResultDTO> join(@RequestBody MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ResponseDto.onSuccess(MemberConverter.toJoinResultDTO(member), Code.OK);
    }
}
