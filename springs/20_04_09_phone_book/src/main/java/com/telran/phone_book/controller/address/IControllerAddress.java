package com.telran.phone_book.controller.address;

import com.telran.phone_book.dto.AddressDto;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

public interface IControllerAddress {

    void createAddress(@Valid AddressDto addressDTO);

    AddressDto editAddress(@Valid AddressDto addressDTO);

    AddressDto removeAddress(@RequestParam(value = "id") @Min(1) int id);

    List<AddressDto> getAllAddressesByContactId(@RequestParam(value = "id") @Min(1) int id);
}