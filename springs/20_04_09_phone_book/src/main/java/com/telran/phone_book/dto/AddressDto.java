package com.telran.phone_book.dto;

import com.telran.phone_book.validation.annotation.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@AddressType
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddressDto {
    public int id;
    @Size(max = 10, min = 3, message = "{com.telran.phone_book.first_name.validation.message}")
    public String country;

    @Size(max = 10, min = 3, message = "{com.telran.phone_book.first_name.validation.message}")
    public String city;

    @Size(max = 25, min = 3, message = "{com.telran.phone_book.first_name.validation.message}")
    public String address;

    @Digits(integer = 10, fraction = 0, message = "{com.telran.phone_book.zip.validation.message}")
    public String zip;

    @Size(max = 10, min = 3, message = "{com.telran.phone_book.first_name.validation.message}")
    public String type;

    public int personId;
}