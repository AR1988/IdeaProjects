package com.telran.phone_book.controller;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.service.AddressService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class AddressController implements IControllerAddress {
    AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PutMapping("/edit/address")
    @Override
    public AddressDTO editAddress(@RequestBody @Valid AddressDTO addressDTO,
                                  @RequestParam(value = "id") @Min(1) int id) {

        return service.editAddress(addressDTO, id);
    }

    @PostMapping("/add/address")
    @Override
    public void createAddress(@RequestBody @Valid AddressDTO addressDTO,
                              @RequestParam(value = "id") @Min(1) int contactDTOId) {

        service.createAddress(addressDTO, contactDTOId);
    }

    @DeleteMapping("/delete/address")
    @Override
    public AddressDTO removeAddress(@RequestParam(value = "id") @Min(1) int id) {

        return service.removeAddress(id);
    }

    @GetMapping("/get/contact-addresses")
    @Override
    public List<AddressDTO> getAllAdressesByContactId(@RequestParam(value = "id") @Min(1) int id) {
        return service.getAllAddressesByContactId(id);
    }
}
