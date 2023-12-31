package study.domain.mapping;
import javax.persistence.*;
import lombok.*;
import study.domain.Member;
import study.domain.Mission;
import study.domain.common.BaseEntity;
import study.domain.enums.MissionStatus;

import java.util.Optional;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setMission(Mission mission){
        if(this.mission != null)
            mission.getMemberMissionList().remove(this);
        this.mission = mission;
        member.getMemberMissionList().add(this);
    }
}
