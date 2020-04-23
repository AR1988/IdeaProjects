package com.telran.phone_book.mapper;

import com.telran.phone_book.dto.AddressDto;
import com.telran.phone_book.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDto mapAddressToDto(Address address) {
        return new AddressDto(address.getCountry(), address.getCity(), address.getAddress(), address.getZip(), address.getType());

    }

    public Address mapAddressToDto(AddressDto addressDto) {
        return new Address(addressDto.getCountry(), addressDto.getCity(), addressDto.getAddress(), addressDto.getZip(), addressDto.getType());
    }
}
