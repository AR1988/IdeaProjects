package com.telran.phone_book.controller;

import com.telran.phone_book.dto.PhoneNumberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IControllerPhone {
    @PostMapping
    void createPhone(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                     @RequestParam(value = "id") @Min(1) int contactDTOId);

    PhoneNumberDTO editPhoneNumber(@RequestBody @Valid PhoneNumberDTO phoneNumberDTO,
                                   @RequestParam(value = "id") @Min(1) int id);

    PhoneNumberDTO removePhoneNumber(@RequestParam(value = "id") @Min(1) int id);

    List<PhoneNumberDTO> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id);
}