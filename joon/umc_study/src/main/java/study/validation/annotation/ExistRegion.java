package study.validation.annotation;

import study.validation.validator.RegionExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = RegionExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegion {
    String message() default "해당하는 지역이 없습니다.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};

}
