package com.telran.phone_book.service;

import com.telran.phone_book.dto.ContactDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IContactService {

    void createContact(ContactDTO contactDTO);

    ContactDTO editContact(ContactDTO contactDTO, int id);

    ContactDTO getContactById(int id);

    List<ContactDTO> getAllContacts();

    List<ContactDTO> getAllContactsWithAllPhones();

    List<ContactDTO> getAllContactsWithAllAddresses();

    List<ContactDTO> getAllContactsByName(String name);

    List<ContactDTO> getAllContactsByLastName(String lastName);

    ContactDTO removeContact(int id);
}
