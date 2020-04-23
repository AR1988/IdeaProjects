package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IAddressService {

    void createAddress(AddressDto addressDTO);

    AddressDto editAddress(AddressDto addressDTO);

    AddressDto removeAddress(int id);

    void removeAllAddressesByContact(int id);

    List<AddressDto> getAllAddressesByContact(int id);
}