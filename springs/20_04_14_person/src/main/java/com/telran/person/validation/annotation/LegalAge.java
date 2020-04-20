package com.telran.person.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = LegalAgeValidator.class)
public @interface LegalAge {

    int value() default 18;

    String message() default "{com.telran.person.legal_age.validation.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
