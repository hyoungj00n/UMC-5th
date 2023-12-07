package study.validation.annotation;

import study.validation.validator.RegionExistValidator;
import study.validation.validator.StoreExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StoreExistValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistStore {
    String message() default "해당하는 가게가 없습니다.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};

}
