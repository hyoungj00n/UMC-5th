package study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.base.ErrorStatus;
import study.domain.Region;
import study.service.RegionService.RegionQueryService;
import study.validation.annotation.ExistRegion;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.*;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion,Long> {

    private final RegionQueryService regionQueryService;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Region> targt = regionQueryService.findRegion(value);

        if (targt.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REGION_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return false;
    }
}
