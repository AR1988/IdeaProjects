package com.telran.phone_book.service;

import com.telran.phone_book.dto.ContactDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IContactService {

    void createContact(ContactDto contactDTO);

    ContactDto editContact(ContactDto contactDTO);

    ContactDto getContactById(int id);

    List<ContactDto> getAllContacts();

    List<ContactDto> getAllContactsByName(String name);

    List<ContactDto> getAllContactsByLastName(String lastName);

    ContactDto removeContact(int id);
}