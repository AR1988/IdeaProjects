package com.telran.phone_book.controller;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.service.MainService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class Controller implements IController {
    MainService mainService;

    public Controller(MainService mainService) {
        this.mainService = mainService;
    }

    @PostMapping("/add/contact")
    @Override
    public void createContact(@RequestBody @Valid ContactDTO contactDTO) {

        mainService.createContact(contactDTO);
    }

    @PutMapping("/edit/contact")
    @Override
    public ContactDTO editContact(@RequestBody @Valid ContactDTO contactDTO,
                                  @RequestParam(value = "id") @Min(1) int id) {

        return mainService.editContact(contactDTO, id);
    }

    @GetMapping("/get/contact")
    @Override
    public ContactDTO getContactById(@RequestParam(value = "id") @Min(1) int id) {

        return mainService.getContactById(id);
    }

    @GetMapping("/get/all")
    @Override
    public List<ContactDTO> getAllContacts() {

        return mainService.getAllContacts();
    }

    @GetMapping("/get/by-name")
    @Override
    public List<ContactDTO> getAllContactsByName(@RequestParam(value = "name") String name) {

        return mainService.getAllContactsByName(name);
    }

    @GetMapping("/get/by-lastname")
    @Override
    public List<ContactDTO> getAllContactsByLastName(@RequestParam(value = "last-name") String lastName) {

        return mainService.getAllContactsByLastName(lastName);
    }

    @DeleteMapping("/delete/contact")
    @Override
    public ContactDTO removeContact(@RequestParam(value = "id") @Min(1) int id) {

        return mainService.removeContact(id);
    }

    @PutMapping("/edit/address")
    @Override
    public AddressDTO editAddress(@RequestBody @Valid AddressDTO addressDTO,
                                  @RequestParam(value = "id") @Min(1) int id) {

        return mainService.editAddress(addressDTO, id);
    }

    @PostMapping("/add/address")
    @Override
    public void createAddress(@RequestBody @Valid AddressDTO addressDTO,
                              @RequestParam(value = "id") @Min(1) int contactDTOId) {

        mainService.createAddress(addressDTO, contactDTOId);
    }

    @DeleteMapping("/delete/address")
    @Override
    public AddressDTO removeAddress(@RequestParam(value = "contact-id") @Min(1) int contactId,
                                    @RequestParam(value = "id") @Min(1) int id) {

        return mainService.removeAddress(contactId, id);
    }

    @GetMapping("/get/contact-addresses")
    @Override
    public List<AddressDTO> getAllAdressesByContactId(@RequestParam(value = "id") @Min(1) int id) {
        return mainService.getAllAddressesByContactId(id);
    }

    @PostMapping("/add/phone")
    @Override
    public void createPhone(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                            @RequestParam(value = "id") @Min(1) int contactDTOId) {

        mainService.createPhone(phoneNumberDTO, contactDTOId);
    }

    @PutMapping("/edit/phone")
    @Override
    public PhoneNumberDTO editPhoneNumber(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                                          @RequestParam(value = "id") @Min(1) int id) {

        return mainService.editPhoneNumber(phoneNumberDTO, id);
    }

    @DeleteMapping("/delete/phone")
    @Override
    public PhoneNumberDTO removePhoneNumber(@RequestParam(value = "contact-id") @Min(1) int contactId,
                                            @RequestParam(value = "id") @Min(1) int id) {

        return mainService.removePhoneNumber(contactId, id);
    }

    @GetMapping("/get/contact-phones")
    @Override
    public List<PhoneNumberDTO> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id) {
        return mainService.getAllPhoneNumberByContactId(id);
    }

//    @DeleteMapping("/delete/addresses")
//    public void removeAllAddressesByContactId(@RequestParam(value = "id") @Min(1) int id) {
//        serviceImplm.removeAllAddressesByContactId(id);
//    }
}
