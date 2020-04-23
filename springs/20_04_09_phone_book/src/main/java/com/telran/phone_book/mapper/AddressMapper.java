package com.telran.phone_book.mapper;

import com.telran.phone_book.dto.AddressDto;
import com.telran.phone_book.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto mapAddressToDto(Address address) {
        return new AddressDto(address.getCountry(),
                address.getCity(),
                address.getAddress(),
                address.getZip(),
                address.getType(),
                address.getContact().getId()
        );
    }
}
