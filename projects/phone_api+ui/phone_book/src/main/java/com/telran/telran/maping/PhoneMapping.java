package com.telran.telran.maping;

import com.telran.telran.dto.PhoneDto;
import com.telran.telran.entity.Contact;
import com.telran.telran.entity.Phone;
import com.telran.telran.repo.ContactRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@AllArgsConstructor
public class PhoneMapping {
    ContactRepo repo;

    public PhoneDto phoneToPhoneDto(Phone phone) {
        return new PhoneDto(phone.getId(),
                phone.getCode(),
                phone.getNumber(),
                phone.getType(),
                phone.getContact().getId());
    }

    public Phone phoneDtoToPhone(PhoneDto phoneDto) {
        Contact contact = repo.findById(phoneDto.contactId).orElseThrow(() -> new EntityNotFoundException("CONTACT_NOT_FOUND"));
        return new Phone(phoneDto.getCode(),
                phoneDto.getNumber(),
                phoneDto.getType(),
                contact);
    }
}
