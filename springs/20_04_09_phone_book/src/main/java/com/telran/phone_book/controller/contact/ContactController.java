package com.telran.phone_book.controller.contact;

import com.telran.phone_book.dto.ContactDto;
import com.telran.phone_book.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Min;
import java.util.List;

//@RestController
@Controller
//@Validated
@AllArgsConstructor
public class ContactController implements IControllerContact {
    //TODO check all mapping (Get,Del,Post,Put)
    @Autowired
    private final ContactService service;


    @GetMapping("/contact")
    public String newContactFrom(Model model) {
        model.addAttribute("contact", new ContactDto());
        return "contact-form";
    }


    @PostMapping("/contact")
    @Override
    public ModelAndView createContact(@ModelAttribute("contactDto") ContactDto contactDto) {

        System.out.println("Create Contact_Controller: \n" +
                " " + contactDto.getId() +
                " " + contactDto.getName() +
                " " + contactDto.getLastName() +
                " " + contactDto.getBirthday() +
                " " + contactDto.addresses.size() +
                " " + contactDto.phoneNumbers.size());

        if (contactDto.getId() == 0)
            service.createContact(contactDto);
        else
            service.editContact(contactDto);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/contact/{id}/edit")
    @Override
    public String editContact(Model model, @PathVariable int id) {
        ContactDto contactDto = service.getContactById(id);
        //        TODO sout
        System.out.println("Edit Contact_Controller:\n" +
                " " + contactDto.getId() +
                " " + contactDto.getName() +
                " " + contactDto.getLastName() +
                " " + contactDto.getBirthday() +
                " " + contactDto.addresses.size() +
                " " + contactDto.phoneNumbers.size());

        model.addAttribute("contact", contactDto);
        return "contact-form";
    }

    @GetMapping("contact/{id}")
    @Override
    public String getContactById(@PathVariable @Min(1) int id, Model model) {
        ContactDto contactDto = service.getContactById(id);
        model.addAttribute("contact", contactDto);
        model.addAttribute("numbers", contactDto.getPhoneNumbers());
        return "contact";
    }

    @GetMapping("/")
    @Override
    public String getAllContacts(Model model) {
        List<ContactDto> contactDtos = service.getAllContacts();
        model.addAttribute("contacts", contactDtos);
        return "contacts";
    }

    @GetMapping("/find/name")
    @Override
    public String getAllContactsByName(@RequestParam(value = "name") String name, Model model) {
        List<ContactDto> allContactsByName = service.getAllContactsByName(name);
        model.addAttribute("contactByName", allContactsByName);
        return "search-result";
    }

    @GetMapping("/find/last")
    @Override
    public String getAllContactsByLastName(@RequestParam(value = "last-name") String lastName, Model model) {
        List<ContactDto> allContactsByLastName = service.getAllContactsByLastName(lastName);
        model.addAttribute("contactByLastName", allContactsByLastName);
        return "search-result";
    }

    @GetMapping("/contact/{id}/remove/")
    @Override
    public ModelAndView removeContact(@PathVariable @Min(1) int id, Model model) {
        service.removeContact(id);
        return new ModelAndView("redirect:/");
    }
}
