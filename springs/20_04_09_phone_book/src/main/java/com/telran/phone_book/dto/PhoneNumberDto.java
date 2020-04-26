package com.telran.phone_book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

//@PhoneType
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PhoneNumberDto {
    int id;
    @Digits(integer = 12, fraction = 0, message = "{com.telran.phone_book.code.validation.message}")
    public int code;

    @Digits(integer = 12, fraction = 0, message = "{com.telran.phone_book.number.validation.message}")
    public long number;

    @Size(min = 4, max = 8)

    public String type;

    public int personId;
}