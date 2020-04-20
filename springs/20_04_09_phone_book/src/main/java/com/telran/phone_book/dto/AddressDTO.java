package com.telran.phone_book.dto;

import com.telran.phone_book.validation.annotation.AddressType;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
@AddressType
public class AddressDTO {
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

    public AddressDTO(String city, String country, String address, String zip, String type) {
        this.city = city;
        this.country = country;
        this.address = address;
        this.zip = zip;
        this.type = type;
    }

    public AddressDTO() {
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getType() {
        return type;
    }
}