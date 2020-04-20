package com.telran.phone_book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;



public class ContactDTO {
    int id;

    @Size(max = 10, min = 3, message = "{com.telran.phone_book.first_name.validation.message}")
    public String name;

    @Size(max = 10, min = 3, message = "{com.telran.phone_book.first_name.validation.message}")
    public String lastName;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @PastOrPresent
    public LocalDate birthday;

    public List<AddressDTO> addresses;
    public List<PhoneNumberDTO> numbers;

    public ContactDTO(int id, String name, String lastName, LocalDate birthday, List<AddressDTO> addresses, List<PhoneNumberDTO> numbers) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.addresses = addresses;
        this.numbers = numbers;
    }

    public ContactDTO(int id, String name, String lastName, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public ContactDTO() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public List<PhoneNumberDTO> getNumbers() {
        return numbers;
    }
}
