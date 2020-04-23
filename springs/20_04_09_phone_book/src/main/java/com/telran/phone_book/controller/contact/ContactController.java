package com.telran.phone_book.controller.contact;

import com.telran.phone_book.dto.ContactDto;
import com.telran.phone_book.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class ContactController implements IControllerContact {

    ContactService service;

    @PostMapping("/add/contact")
    @Override
    public void createContact(@RequestBody @Valid ContactDto contactDTO) {
        service.createContact(contactDTO);
    }

    @PutMapping("/edit/contact")
    @Override
    public ContactDto editContact(@RequestBody @Valid ContactDto contactDTO) {
        return service.editContact(contactDTO);
    }

    @GetMapping("/get/contact")
    @Override
    public ContactDto getContactById(@RequestParam(value = "id") @Min(1) int id) {
        return service.getContactById(id);
    }

    @GetMapping("/get/all")
    @Override
    public List<ContactDto> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/get/by-name")
    @Override
    public List<ContactDto> getAllContactsByName(@RequestParam(value = "name") String name) {
        return service.getAllContactsByName(name);
    }

    @GetMapping("/get/by-lastname")
    @Override
    public List<ContactDto> getAllContactsByLastName(@RequestParam(value = "last-name") String lastName) {
        return service.getAllContactsByLastName(lastName);
    }

    @DeleteMapping("/delete/contact")
    @Override
    public ContactDto removeContact(@RequestParam(value = "id") @Min(1) int id) {
        return service.removeContact(id);
    }
}
