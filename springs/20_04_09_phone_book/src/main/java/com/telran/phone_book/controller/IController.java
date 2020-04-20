package com.telran.phone_book.controller;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.dto.PhoneNumberDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IController {

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
//    Address

    AddressDTO editAddress(@Valid AddressDTO addressDTO,
                           @Min(1) int id);

    void createAddress(@Valid AddressDTO addressDTO,
                       @Min(1) int contactDTOId);

    AddressDTO removeAddress(@RequestParam(value = "contact-id") @Min(1) int contactId,
                             @RequestParam(value = "id") @Min(1) int id);

    List<AddressDTO> getAllAdressesByContactId(@RequestParam(value = "id") @Min(1) int id);

    //    Phone
    void createPhone(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                     @RequestParam(value = "id") @Min(1) int contactDTOId);

    PhoneNumberDTO editPhoneNumber(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                                   @RequestParam(value = "id") @Min(1) int id);

    PhoneNumberDTO removePhoneNumber(@RequestParam(value = "contact-id") @Min(1) int contactId,
                                     @RequestParam(value = "id") @Min(1) int id);

    List<PhoneNumberDTO> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id);
}