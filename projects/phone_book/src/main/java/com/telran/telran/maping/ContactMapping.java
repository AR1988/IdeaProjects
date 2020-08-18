package com.telran.telran.maping;

import com.telran.telran.dto.ContactDto;
import com.telran.telran.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapping {

    public ContactDto contactToDto(Contact contact) {
        return new ContactDto(contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getAge(),
                contact.getType()
        );
    }

    public Contact contactDtoToContact(ContactDto contactDto) {
        return new Contact(contactDto.getId(),
                contactDto.getName(),
                contactDto.getLastName(),
                contactDto.getAge(),
                contactDto.getType()
        );
    }
}
