package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDto;
import com.telran.phone_book.dto.ContactDto;
import com.telran.phone_book.dto.PhoneNumberDto;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;
import com.telran.phone_book.mapper.AddressMapper;
import com.telran.phone_book.mapper.ContactMapper;
import com.telran.phone_book.mapper.PhoneMapper;
import com.telran.phone_book.repo.IRepoAddress;
import com.telran.phone_book.repo.IRepoContact;
import com.telran.phone_book.repo.IRepoPhone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor

public class ContactService implements IContactService {

    static final String CONTACT_NOT_FOUND = "Contact not found";

    private final IRepoContact repoContact;
    private final IRepoPhone repoPhone;
    private final IRepoAddress repoAddress;

    private final ContactMapper contactMapper;
    private final PhoneMapper phoneMapper;
    private final AddressMapper addressMapper;


    @Override
    public void createContact(ContactDto contactDTO) {
        Contact contact = convertToContactDto(contactDTO);
        //        TODO sout
        System.out.println("Create Contact_Service:\n" +
                " " + contact.getId() +
                " " + contact.getName() +
                " " + contact.getLastName() +
                " " + contact.getBirthday());

        repoContact.save(contact);
    }


    @Override
    public ContactDto editContact(ContactDto contactDTO) {
        Contact contact = getContact(contactDTO.getId());

        //        TODO sout
        System.out.println("Edit by id Contact_Service:\n" +
                " " + contact.getId() +
                " " + contact.getName() +
                " " + contact.getLastName() +
                " " + contact.getBirthday());

        contact.setName(contactDTO.getName());
        contact.setLastName(contactDTO.getLastName());
        contact.setBirthday(contactDTO.getBirthday());

        repoContact.save(contact);

        return convertToDto(contact);
    }

    @Override
    public ContactDto getContactById(int id) {
        Contact contact = getContact(id);
        //        TODO sout
        System.out.println("Get by id Contact_Service:\n" +
                " " + contact.getId() +
                " " + contact.getName() +
                " " + contact.getLastName() +
                " " + contact.getBirthday());

        return convertToDto(contact);
    }

    @Override
    public List<ContactDto> getAllContacts() {
        return repoContact.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> getAllContactsByName(String name) {
        List<Contact> contacts = repoContact.findAllByName(name);

        return contacts
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContactDto> getAllContactsByLastName(String lastName) {
        List<Contact> contacts = repoContact.findAllByLastName(lastName);

        return contacts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto removeContact(int id) {
        Contact contact = getContact(id);

        repoPhone.deleteAllByContact(contact);
        repoAddress.deleteAllByContact(contact);
        repoContact.deleteById(id);

        return convertToDto(contact);
    }

    private List<PhoneNumberDto> getAllPhonesByContact(Contact contact) {
        List<PhoneNumber> phones = repoPhone.findAllByContact(contact);

        return phones
                .stream()
                .map(this::convertPhoneNumberToDto)
                .collect(Collectors.toList());
    }


    private List<AddressDto> getAllAddressesByContact(Contact contact) {
        List<Address> phones = repoAddress.findAllByContact(contact);

        return phones
                .stream()
                .map(this::convertFromAddressToAddressDTO)
                .collect(Collectors.toList());

    }

    private PhoneNumberDto convertPhoneNumberToDto(PhoneNumber phoneNumber) {
        return phoneMapper.mapPhoneNumberToDto(phoneNumber);
    }

    private AddressDto convertFromAddressToAddressDTO(Address address) {
        return addressMapper.mapAddressToDto(address);
    }

    private ContactDto convertToDto(Contact contact) {
        return contactMapper.mapContactToContactDto(contact, getAllPhonesByContact(contact), getAllAddressesByContact(contact));
    }

    private Contact convertToContactDto(ContactDto contactDTO) {
        return contactMapper.mapContactDtoToContact(contactDTO);
    }

    private Contact getContact(int id) {
        return repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
    }

    public void editContactNoDto(Contact contact) {
        contact.setName(contact.getName());
        contact.setLastName(contact.getLastName());
        contact.setBirthday(contact.getBirthday());
    }
    public void createContactNoDto(Contact contact) {
        repoContact.save(contact);
    }
}