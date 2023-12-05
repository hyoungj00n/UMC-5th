package study.web.dto;

import lombok.Getter;

import javax.persistence.Column;

public class RegionRequestDTO {

    @Getter
    public static class StoreDTO{


        private String name;

        private String address;

        private Float score;
    }
}
