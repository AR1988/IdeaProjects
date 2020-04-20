package com.telran.phone_book.dto;

import com.telran.phone_book.validation.annotation.PhoneType;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@PhoneType
public class PhoneNumberDTO {
    @Digits(integer = 12, fraction = 0, message = "{com.telran.phone_book.code.validation.message}")
    public int code;
    @Digits(integer = 12, fraction = 0, message = "{com.telran.phone_book.number.validation.message}")
    public long number;
    @Size(min = 4, max = 8)

    public String type;

    public PhoneNumberDTO(int code, long number, String type) {
        this.code = code;
        this.number = number;
        this.type = type;
    }

    public PhoneNumberDTO() {
    }

    public int getCode() {
        return code;
    }

    public long getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}