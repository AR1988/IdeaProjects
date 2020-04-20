package com.telran.phone_book.controller;

import com.telran.phone_book.dto.AddressDTO;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IControllerAddress {

    void createAddress(@Valid AddressDTO addressDTO,
                       @Min(1) int contactDTOId);

    AddressDTO editAddress(@Valid AddressDTO addressDTO,
                           @Min(1) int id);

    AddressDTO removeAddress(@RequestParam(value = "id") @Min(1) int id);

    List<AddressDTO> getAllAdressesByContactId(@RequestParam(value = "id") @Min(1) int id);
}
