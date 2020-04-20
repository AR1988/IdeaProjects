package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IUtils {

    PhoneNumberDTO convertFromPhoneNumberToPhoneNumberDTO(PhoneNumber phoneNumber);

    AddressDTO convertFromAddressToAddressDTO(Address address);

    ContactDTO convertFromContactToContactDTO(Contact contact, List<PhoneNumberDTO> phones, List<AddressDTO> addresses);

    Contact convertFromContactDTOToContact(ContactDTO contactDTO);
}