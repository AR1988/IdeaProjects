package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Utils implements IUtils {
    @Override
    public PhoneNumberDTO convertFromPhoneNumberToPhoneNumberDTO(PhoneNumber phoneNumber) {
        return new PhoneNumberDTO(
                phoneNumber.getCode(),
                phoneNumber.getNumber(),
                phoneNumber.getType()
        );
    }


    @Override
    public AddressDTO convertFromAddressToAddressDTO(Address address) {
        return new AddressDTO(
                address.getCity(),
                address.getCountry(),
                address.getAddress(),
                address.getZip(),
                address.getType()
        );
    }


    @Override
    public ContactDTO convertFromContactToContactDTO(Contact contact, List<PhoneNumberDTO> phones, List<AddressDTO> addresses) {
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getDate(),
                addresses,
                phones);
    }

    @Override
    public Contact convertFromContactDTOToContact(ContactDTO contactDTO) {
        return new Contact(contactDTO.getId(),
                contactDTO.getName(),
                contactDTO.getLastName(),
                contactDTO.getBirthday());

    }

//    @Override
//    public List<PhoneNumberDTO> getAllPhonesByContact(Contact contact) {
//        return null;
//    }
//
//    @Override
//    public List<AddressDTO> getAllAddressesByContact(Contact contact) {
//        return null;
//    }
}
