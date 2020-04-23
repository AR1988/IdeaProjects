package com.telran.phone_book.mapper;

import com.telran.phone_book.dto.PhoneNumberDto;
import com.telran.phone_book.entity.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {

    public PhoneNumberDto mapPhoneNumberToDto(PhoneNumber phoneNumber) {
        return new PhoneNumberDto(phoneNumber.getCode(),
                phoneNumber.getNumber(),
                phoneNumber.getType(),
                phoneNumber.getContact().getId()
        );
    }
}
