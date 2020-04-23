package com.telran.phone_book.controller.contact;

import com.telran.phone_book.dto.ContactDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IControllerContact {

    void createContact(@RequestBody @Valid ContactDto contactDTO);

    ContactDto editContact(@RequestBody @Valid ContactDto contactDTO);

    ContactDto getContactById(@RequestParam(value = "id") @Min(1) int id);

    List<ContactDto> getAllContacts();

//    @GetMapping
//    List<ContactDTO> getAllContactsWithAllPhones();
//
//    @GetMapping
//    List<ContactDTO> getAllContactsWithAllAddresses();

    List<ContactDto> getAllContactsByName(@RequestParam(value = "last-name") String lastName);

    List<ContactDto> getAllContactsByLastName(@RequestParam(value = "last-name") String lastName);

    ContactDto removeContact(@RequestParam(value = "id") @Min(1) int id);
}