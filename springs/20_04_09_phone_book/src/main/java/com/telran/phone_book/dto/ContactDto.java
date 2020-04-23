package com.telran.phone_book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor

@Getter
public class ContactDto {
    int id;

    @Size(max = 10, min = 3)
    public String name;

    @Size(max = 10, min = 3)
    public String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @PastOrPresent
    public LocalDate birthday;

    public ContactDto(int id, String name,  String lastName,  LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public List<AddressDto> addresses;
    public List<PhoneNumberDto> numbers;

}