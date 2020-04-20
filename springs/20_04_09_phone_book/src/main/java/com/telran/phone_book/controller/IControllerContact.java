package com.telran.phone_book.controller;

import com.telran.phone_book.dto.ContactDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IControllerContact {

    void createContact(@RequestBody @Valid ContactDTO contactDTO);

    ContactDTO editContact(@RequestBody @Valid ContactDTO contactDTO,
                           @RequestParam(value = "id") @Min(1) int id);

    ContactDTO getContactById(@RequestParam(value = "id") @Min(1) int id);

    List<ContactDTO> getAllContacts();

//    @GetMapping
//    List<ContactDTO> getAllContactsWithAllPhones();
//
//    @GetMapping
//    List<ContactDTO> getAllContactsWithAllAddresses();

    List<ContactDTO> getAllContactsByName(@RequestParam(value = "last-name") String lastName);

    List<ContactDTO> getAllContactsByLastName(@RequestParam(value = "last-name") String lastName);

    ContactDTO removeContact(@RequestParam(value = "id") @Min(1) int id);
}