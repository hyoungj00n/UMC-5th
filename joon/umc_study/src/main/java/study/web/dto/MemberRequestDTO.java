package study.web.dto;

import lombok.Getter;
import study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer age;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
