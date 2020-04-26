//package com.telran.phone_book.controller.phone.old;
//
//import com.telran.phone_book.dto.PhoneNumberDto;
//import com.telran.phone_book.service.PhoneService;
//import lombok.AllArgsConstructor;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Min;
//import java.util.List;
//
////@Controller
//@Validated
//@AllArgsConstructor
//public class PhoneController implements IControllerPhone {
//
//    PhoneService service;
//
//
//    @GetMapping("phone")
//    public String newPhoneFrom(Model model) {
//        model.addAttribute("contact", new PhoneNumberDto());
//        return "phone-form";
//    }
//
//    @PostMapping("phone")
//    public ModelAndView createContact(@ModelAttribute PhoneNumberDto phoneNumberDto) {
//
//        if (phoneNumberDto.getId() == 0)
//            service.createPhone(phoneNumberDto);
//        else
//            service.editPhoneNumber(phoneNumberDto);
//        return new ModelAndView("redirect:/");
//    }
//
//    @PostMapping("/add/phone")
//    @Override
//    public void createPhone(@RequestBody @Valid PhoneNumberDto phoneNumberDTO) {
//        service.createPhone(phoneNumberDTO);
//    }
//
//    @PutMapping("/edit/phone")
//    @Override
//    public PhoneNumberDto editPhoneNumber(@RequestBody @Valid PhoneNumberDto phoneNumberDTO) {
//        return service.editPhoneNumber(phoneNumberDTO);
//    }
//
//    @DeleteMapping("/delete/phone")
//    @Override
//    public PhoneNumberDto removePhoneNumber(@RequestParam(value = "id") @Min(1) int id) {
//        return service.removePhoneNumber(id);
//    }
//
//    @GetMapping("/get/contact-phones")
//    @Override
//    public List<PhoneNumberDto> getAllPhonesByContactId(@RequestParam(value = "id") @Min(1) int id) {
//        return service.getAllPhoneNumberByContact(id);
//    }
//}