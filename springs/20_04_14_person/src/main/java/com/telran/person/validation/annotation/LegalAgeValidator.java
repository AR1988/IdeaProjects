package com.telran.person.validation.annotation;

import com.telran.person.dto.PersonDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class LegalAgeValidator implements ConstraintValidator<LegalAge, PersonDto> {
    int legalAge;

    @Override
    public void initialize(LegalAge constraintAnnotation) {
        legalAge = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(PersonDto value, ConstraintValidatorContext context) {
        return Period.between(value.birthday, LocalDate.now()).getYears() >= legalAge;
    }
}
