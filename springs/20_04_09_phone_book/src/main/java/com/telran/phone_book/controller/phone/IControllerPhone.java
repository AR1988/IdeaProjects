package com.telran.phone_book.controller.phone;

import com.telran.phone_book.dto.PhoneNumberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IControllerPhone {
    @PostMapping
    void createPhone(@RequestBody @Valid PhoneNumberDto phoneNumberDTO);

    PhoneNumberDto editPhoneNumber(@RequestBody @Valid PhoneNumberDto phoneNumberDTO);

    PhoneNumberDto removePhoneNumber(@RequestParam(value = "id") @Min(1) int id);

    List<PhoneNumberDto> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id);
}