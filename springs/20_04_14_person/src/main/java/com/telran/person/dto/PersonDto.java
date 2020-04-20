package com.telran.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telran.person.validation.annotation.FullNameMaxLength;
import com.telran.person.validation.annotation.LegalAge;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@FullNameMaxLength(15)
@LegalAge
public class PersonDto {

    public int id;

    @Size(max = 10, min = 1, message = "{com.telran.person.first_name.validation.message}")
    public String firstName;

    @Size(max = 10, min = 3)
    public String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @PastOrPresent

    public LocalDate birthday;

    public PersonDto() {
    }

    public PersonDto(int id, String firstName, String lastName, LocalDate birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
