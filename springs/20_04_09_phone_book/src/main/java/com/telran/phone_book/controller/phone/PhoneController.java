package com.telran.phone_book.controller.phone;

import com.telran.phone_book.dto.PhoneNumberDto;
import com.telran.phone_book.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class PhoneController implements IControllerPhone {

    PhoneService service;

    @PostMapping("/add/phone")
    @Override
    public void createPhone(@RequestBody @Valid PhoneNumberDto phoneNumberDTO) {
        service.createPhone(phoneNumberDTO);
    }

    @PutMapping("/edit/phone")
    @Override
    public PhoneNumberDto editPhoneNumber(@RequestBody @Valid PhoneNumberDto phoneNumberDTO) {
        return service.editPhoneNumber(phoneNumberDTO);
    }

    @DeleteMapping("/delete/phone")
    @Override
    public PhoneNumberDto removePhoneNumber(@RequestParam(value = "id") @Min(1) int id) {
        return service.removePhoneNumber(id);
    }

    @GetMapping("/get/contact-phones")
    @Override
    public List<PhoneNumberDto> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id) {
        return service.getAllPhoneNumberByContact(id);
    }
}