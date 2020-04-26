package com.telran.phone_book.controller.contact;

import com.telran.phone_book.dto.ContactDto;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Min;

public interface IControllerContact {

    ModelAndView createContact(ContactDto contactDTO);

    String editContact(Model model, int id);

    String getContactById(@Min(1) int id, Model model);

    String getAllContacts(Model model);

//    @GetMapping
//    List<ContactDTO> getAllContactsWithAllPhones();
//
//    @GetMapping
//    List<ContactDTO> getAllContactsWithAllAddresses();

    String getAllContactsByName(String lastName, Model model);

    String getAllContactsByLastName(String lastName, Model model);

    ModelAndView removeContact(@Min(1) int id, Model model);
}