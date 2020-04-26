package com.telran.phone_book.mapper;

import com.telran.phone_book.dto.AddressDto;
import com.telran.phone_book.dto.ContactDto;
import com.telran.phone_book.dto.PhoneNumberDto;
import com.telran.phone_book.entity.Contact;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class ContactMapper {

    public ContactDto mapContactToContactDto(Contact contact, List<PhoneNumberDto> phones, List<AddressDto> addresses) {
        return new ContactDto(contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getBirthday(),
                addresses,
                phones);
    }

    public Contact mapContactDtoToContact(ContactDto contactDto) {
        Contact contact = new Contact(contactDto.getId(),
                contactDto.getName(),
                contactDto.getLastName(),
                contactDto.getBirthday());
//        TODO sout
//        System.out.println("Contact Mapper:\n" +
//                " " + contact.getId() +
//                " " + contact.getName() +
//                " " + contact.getLastName() +
//                contact.getBirthday());

        return contact;
    }
}
