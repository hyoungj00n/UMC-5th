package study.converter;

import study.domain.Member;
import study.domain.Mission;
import study.domain.mapping.MemberMission;
import study.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}
