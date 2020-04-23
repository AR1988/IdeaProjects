package com.telran.phone_book.mapper;

import com.telran.phone_book.dto.ContactDto;
import com.telran.phone_book.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {
    public ContactDto mapContactToDto(Contact contact) {
        return new ContactDto(contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getBirthday());
    }

    public Contact mapContactDtoToContact(ContactDto contactDto) {
        return new Contact(contactDto.getId(),
                contactDto.getName(),
                contactDto.getLastName(),
                contactDto.getBirthday());
    }


}
