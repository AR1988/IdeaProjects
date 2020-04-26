package com.telran.phone_book.controller.phone;

import com.telran.phone_book.dto.PhoneNumberDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Min;

public interface IControllerPhone {


    @PostMapping("/person/{id}/number")
    ModelAndView createPhone(@Valid PhoneNumberDto phoneNumberDTO, @PathVariable int id);

    @PutMapping("/number/{id}")
    String editPhoneNumber(@Valid PhoneNumberDto phoneNumberDTO, @PathVariable int id, Model model);

    @GetMapping("/number/{id}")
    ModelAndView removePhoneNumber(@Min(1) int id);

    //    String getAllPhonesByContactId(@Min(1) int id);
}