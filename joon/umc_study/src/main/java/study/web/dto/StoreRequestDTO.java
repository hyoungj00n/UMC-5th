package study.web.dto;

import lombok.Getter;
import study.domain.Member;

import java.time.LocalDate;
import java.util.List;


public class StoreRequestDTO {

    @Getter
    public static class ReviewDTO{


        private String title;

        private float score;

    }

    @Getter
    public static class MissionDTO{
        private Integer reward;

        private LocalDate deadline;

        private String missionSpec;
        List<Long> memberList;
    }
}
