package com.telran.phone_book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ContactDto {

    private int id;

    @Size(max = 15, min = 3)
    private String name;

    @Size(max = 15, min = 3)
    private String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @PastOrPresent
    private LocalDate birthday;


    public ContactDto(int id,
                      String name,
                      String lastName,
                      LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public List<AddressDto> addresses = new ArrayList<>();

    public List<PhoneNumberDto> phoneNumbers = new ArrayList<>();
}