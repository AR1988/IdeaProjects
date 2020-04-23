package com.telran.phone_book.validation.annotation;

import com.telran.phone_book.dto.PhoneNumberDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneTypeValidator implements ConstraintValidator<PhoneType, PhoneNumberDto> {
    private static final String FILE = "src/phone_type.txt";


    @Override
    public boolean isValid(PhoneNumberDto value, ConstraintValidatorContext context) {
        List<String> list = new ArrayList<>();
        String res = value.type;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE));
            String str;
            while ((str = reader.readLine()) != null)
                list.add(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.stream().anyMatch(s -> s.equals(res));
    }
}
