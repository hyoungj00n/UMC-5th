package study.converter;

import study.domain.Member;
import study.domain.mapping.MemberMission;
import study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static List<MemberMission> toMemberMission(List<Member> MemberList){
        return MemberList.stream()
                .map(member ->
                        MemberMission.builder()
                                .member(member)
                                .build()
                ).collect(Collectors.toList());
    }
}
