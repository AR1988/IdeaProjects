package com.telran.phone_book.controller.address;

import com.telran.phone_book.dto.AddressDto;
import com.telran.phone_book.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class AddressController implements IControllerAddress {

    AddressService service;

    @PutMapping("/edit/address")
    @Override
    public AddressDto editAddress(@RequestBody @Valid AddressDto addressDTO) {
        return service.editAddress(addressDTO);
    }

    @PostMapping("/add/address")
    @Override
    public void createAddress(@RequestBody @Valid AddressDto addressDTO) {
        service.createAddress(addressDTO);
    }

    @DeleteMapping("/delete/address")
    @Override
    public AddressDto removeAddress(@RequestParam(value = "id") @Min(1) int id) {
        return service.removeAddress(id);
    }

    @GetMapping("/get/contact-addresses")
    @Override
    public List<AddressDto> getAllAddressesByContactId(@RequestParam(value = "id") @Min(1) int id) {
        return service.getAllAddressesByContact(id);
    }
}