package com.telran.telran.service;

import com.telran.telran.dto.ContactDto;
import com.telran.telran.entity.Contact;
import com.telran.telran.maping.ContactMapping;
import com.telran.telran.repo.ContactRepo;
import com.telran.telran.repo.PhoneRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ContactService {
    private final ContactRepo repoContact;
    private final PhoneRepo phoneRepo;
    private final ContactMapping mapping;
    private final String CONTACT_NOT_FOUND = "Contact not found";

    public void create(ContactDto contactDto) {
        repoContact.save(dtoToContact(contactDto));
    }

    @Transactional
    public void edit(ContactDto contactDto) {
        int id = contactDto.getId();
        Contact contactToEdit = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));

        contactToEdit.setName(contactDto.getName());
        contactToEdit.setLastName(contactDto.getLastName());
        contactToEdit.setAge(contactDto.getAge());
        contactToEdit.setType(contactDto.getType());
    }

    public void remove(int id) {
        phoneRepo.deleteAllByContactId(id);
        repoContact.deleteById(id);
    }

    public List<ContactDto> getAll() {
        return repoContact.findAll()
                .stream()
                .map(this::contactToDto)
                .collect(Collectors.toList());

    }

    public ContactDto getById(int id) {
        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
        return contactToDto(contact);
    }

    public List<ContactDto> getByName(String name) {

        return repoContact.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(this::contactToDto)
                .collect(Collectors.toList());
    }

    public List<ContactDto> getByLastName(String name) {
        return repoContact.findAllByLastNameContainingIgnoreCase(name)
                .stream()
                .map(this::contactToDto)
                .collect(Collectors.toList());
    }

//    public List<ContactDto> getByAge(int age) {
//        return repoContact.findAllByAge(age)
//                .stream()
//                .map(this::contactToDto)
//                .collect(Collectors.toList());
//    }

//    public ContactDto getLastContact() {
//        return contactToDto(repoContact.findTopByOrderByIdDesc());
//    }

    private Contact dtoToContact(ContactDto contactDto) {
        return mapping.contactDtoToContact(contactDto);
    }

    private ContactDto contactToDto(Contact contact) {
        return mapping.contactToDto(contact);
    }
}
