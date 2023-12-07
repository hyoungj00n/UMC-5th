package study.converter;


import lombok.Builder;
import study.domain.Mission;
import study.web.dto.MemberResponseDTO;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class MissionConverter {

    public static StoreResponseDTO.CreateMissionResultDTO toCreateMissionResult(Mission mission){
        return StoreResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(StoreRequestDTO.MissionDTO request){

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .memberMissionList(new ArrayList<>())
                .build();

    }
}
