package com.example.n11talenthubbootcampgraduationprojectrsmciftci.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TurkishIdentityNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TurkishIdentityNumber {
    String message() default "Invalid Turkish Identity Number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
