package com.telran.phone_book.controller;

import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.service.PhoneService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class PhoneController implements IControllerPhone {
    PhoneService service;

    public PhoneController(PhoneService service) {
        this.service = service;
    }

    @PostMapping("/add/phone")
    @Override
    public void createPhone(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                            @RequestParam(value = "id") @Min(1) int contactDTOId) {

        service.createPhone(phoneNumberDTO, contactDTOId);
    }

    @PutMapping("/edit/phone")
    @Override
    public PhoneNumberDTO editPhoneNumber(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                                          @RequestParam(value = "id") @Min(1) int id) {

        return service.editPhoneNumber(phoneNumberDTO, id);
    }

    @DeleteMapping("/delete/phone")
    @Override
    public PhoneNumberDTO removePhoneNumber(@RequestParam(value = "id") @Min(1) int id) {

        return service.removePhoneNumber(id);
    }

    @GetMapping("/get/contact-phones")
    @Override
    public List<PhoneNumberDTO> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id) {
        return service.getAllPhoneNumberByContactId(id);
    }
}
