package com.telran.phone_book.controller;

import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.service.ContactService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class ContactController implements IControllerContact {
    ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping("/add/contact")
    @Override
    public void createContact(@RequestBody @Valid ContactDTO contactDTO) {

        service.createContact(contactDTO);
    }

    @PutMapping("/edit/contact")
    @Override
    public ContactDTO editContact(@RequestBody @Valid ContactDTO contactDTO,
                                  @RequestParam(value = "id") @Min(1) int id) {

        return service.editContact(contactDTO, id);
    }

    @GetMapping("/get/contact")
    @Override
    public ContactDTO getContactById(@RequestParam(value = "id") @Min(1) int id) {

        return service.getContactById(id);
    }

    @GetMapping("/get/all")
    @Override
    public List<ContactDTO> getAllContacts() {

        return service.getAllContacts();
    }

    @GetMapping("/get/by-name")
    @Override
    public List<ContactDTO> getAllContactsByName(@RequestParam(value = "name") String name) {

        return service.getAllContactsByName(name);
    }

    @GetMapping("/get/by-lastname")
    @Override
    public List<ContactDTO> getAllContactsByLastName(@RequestParam(value = "last-name") String lastName) {

        return service.getAllContactsByLastName(lastName);
    }

    @DeleteMapping("/delete/contact")
    @Override
    public ContactDTO removeContact(@RequestParam(value = "id") @Min(1) int id) {

        return service.removeContact(id);
    }
}
