package com.telran.phone_book.controller.phone;

import com.telran.phone_book.dto.PhoneNumberDto;
import com.telran.phone_book.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
@AllArgsConstructor
public class PhoneController implements IControllerPhone {

    PhoneService service;

    @GetMapping("phone")
    public String newPhoneFrom(Model model) {
        model.addAttribute("phone", new PhoneNumberDto());
        return "phone-form";
    }

    @PostMapping("phone")
    public ModelAndView createContact(@ModelAttribute PhoneNumberDto phoneNumberDto) {

        if (phoneNumberDto.getId() == 0)
            service.createPhone(phoneNumberDto);
        else
            service.editPhoneNumber(phoneNumberDto);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/contact/{id}/phone")
    @Override
    public ModelAndView createPhone(@ModelAttribute  PhoneNumberDto phoneNumberDTO, @PathVariable int id) {
        if (phoneNumberDTO.getId() == 0)
            service.createPhone(phoneNumberDTO);
        else
            service.editPhoneNumber(phoneNumberDTO);
        return new ModelAndView("redirect:/");
    }

    @PutMapping("/phone/{id}")
    @Override
    public String editPhoneNumber(@ModelAttribute @Valid PhoneNumberDto phoneNumberDTO, @PathVariable int id, Model model) {
        PhoneNumberDto phone = service.getPhoneById(id);
        service.editPhoneNumber(phoneNumberDTO);
        return "phone-form";
    }


    @GetMapping("/phone/{id}")
    @Override
    public ModelAndView removePhoneNumber(@Min(1) int id) {
        service.removePhoneNumber(id);
        return new ModelAndView("redirect:/");
    }

//    @GetMapping("/get/contact-phones")
//    @Override
//    public String getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id) {
//        return service.getAllPhoneNumberByContact(id);
//    }
}