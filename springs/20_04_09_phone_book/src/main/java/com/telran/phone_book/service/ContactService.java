package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.dto.ContactDTO;
import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;
import com.telran.phone_book.repo.IRepoAddress;
import com.telran.phone_book.repo.IRepoContact;
import com.telran.phone_book.repo.IRepoPhone;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ContactService implements IContactService {

    private static final String CONTACT_NOT_FOUND = "Contact not fount";

    private final IRepoContact repoContact;
    private final IRepoPhone repoPhone;
    private final IRepoAddress repoAddress;


    private final Utils utils;


    public ContactService(IRepoContact repoContact, IRepoPhone repoPhone, IRepoAddress repoAddress, Utils utils) {
        this.repoContact = repoContact;
        this.repoPhone = repoPhone;
        this.repoAddress = repoAddress;
        this.utils = utils;
    }

    @Override
    public void createContact(ContactDTO contactDTO) {
        Contact contact = utils.convertFromContactDTOToContact(contactDTO);
        repoContact.save(contact);
    }

    @Override
    public ContactDTO editContact(ContactDTO contactDTO, int id) {
        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));

        contact.setName(contactDTO.getName());
        contact.setLastName(contactDTO.getLastName());
        contact.setDate(contactDTO.getBirthday());

        repoContact.save(contact);
        return convertToDto(contact);
    }

    @Override
    public ContactDTO getContactById(int id) {
        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
        return convertToDto(contact);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        return repoContact.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> getAllContactsWithAllPhones() {
        return null;
    }

    @Override
    public List<ContactDTO> getAllContactsWithAllAddresses() {
        return null;
    }

    //TODO if not found
    @Override
    public List<ContactDTO> getAllContactsByName(String name) {
        List<Contact> contacts = repoContact.findAllByName(name);
        return contacts
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> getAllContactsByLastName(String lastName) {
        List<Contact> contacts = repoContact.findAllByLastName(lastName);
        return contacts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO removeContact(int id) {
        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));

        repoPhone.deleteAllByContactId(id);
        repoAddress.deleteAllByContactId(id);
        repoContact.deleteById(id);

        return convertToDto(contact);
    }

    private List<PhoneNumberDTO> getAllPhonesByContact(Contact contact) {
        List<PhoneNumber> phones = repoPhone.findAllByContactId(contact.getId());
        return phones
                .stream()
                .map(utils::convertFromPhoneNumberToPhoneNumberDTO)
                .collect(Collectors.toList());
    }

    private List<AddressDTO> getAllAddressesByContact(Contact contact) {
        List<Address> phones = repoAddress.findAllByContactId(contact.getId());
        return phones
                .stream()
                .map(utils::convertFromAddressToAddressDTO)
                .collect(Collectors.toList());

    }

    private ContactDTO convertToDto(Contact contact) {
        return utils.convertFromContactToContactDTO(contact, getAllPhonesByContact(contact), getAllAddressesByContact(contact));
    }
}