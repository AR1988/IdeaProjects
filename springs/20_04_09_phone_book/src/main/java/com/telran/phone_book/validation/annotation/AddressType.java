package com.telran.phone_book.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = AddressTypeValidator.class)
public @interface AddressType {

    String value() default "home";

    String message() default "address type not allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
