package study.web.dto;

import lombok.Getter;


public class StoreRequestDTO {

    @Getter
    public static class ReviewDTO{


        private String title;

        private float score;

    }
}
