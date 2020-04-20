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
public class MainService implements IAddressService, IContactService, IPhoneService, IUtils {


    private static final String ADDRESS_NOT_FOUND = "Address not found";
    private static final String CONTACT_NOT_FOUND = "Contact not fount";
    private static final String PHONE_NUMBER_NOT_FOUND = "Phone Number Not found";

    private final IRepoContact repoContact;
    private final IRepoAddress repoAddress;
    private final IRepoPhone repoPhone;

    public MainService(IRepoContact repoContact, IRepoAddress repoAddress, IRepoPhone repoPhone) {
        this.repoContact = repoContact;
        this.repoAddress = repoAddress;
        this.repoPhone = repoPhone;
    }

    @Override
    public void createAddress(AddressDTO addressDTO, int contactDTOId) {
        Address address = new Address(addressDTO.getCity(),
                addressDTO.getCountry(),
                addressDTO.getAddress(),
                addressDTO.getZip(),
                addressDTO.getType(),
                contactDTOId);

        repoAddress.save(address);
    }

    @Override
    public AddressDTO editAddress(AddressDTO addressDTO, int id) {
        Address address = repoAddress.findById(id).orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND));

        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setAddress(addressDTO.getAddress());
        address.setZip(addressDTO.getZip());
        address.setType(addressDTO.getType());

        repoAddress.save(address);
        return convertFromAddressToAddressDTO(address);
    }

    @Override
    public AddressDTO removeAddress(int contactDTOId, int id) {
        Address address = repoAddress.findById(id).orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND));
        repoAddress.deleteByContactIdAndId(contactDTOId, id);
        return convertFromAddressToAddressDTO(address);
    }

    @Override
    public List<AddressDTO> getAllAddressesByContactId(int id) {
        return repoAddress.findAllByContactId(id)
                .stream()
                .map(this::convertFromAddressToAddressDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createContact(ContactDTO contactDTO) {
        Contact contact = convertFromContactDTOToContact(contactDTO);
        repoContact.save(contact);
    }

    @Override
    public ContactDTO editContact(ContactDTO contactDTO, int id) {
        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));

        contact.setId(id);
        contact.setName(contactDTO.getName());
        contact.setLastName(contactDTO.getLastName());
        contact.setDate(contactDTO.getBirthday());

        return convertFromContactToContactDTO(repoContact.save(contact));
    }

    @Override
    public ContactDTO getContactById(int id) {
//        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
        Contact contact = repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
        return convertFromContactToContactDTO(contact);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        return repoContact.findAll()
                .stream()
                .map(this::convertFromContactToContactDTO)
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

    @Override
    public List<ContactDTO> getAllContactsByName(String name) {
        List<Contact> contacts = repoContact.findAllByName(name);
        return contacts.stream().map(this::convertFromContactToContactDTO).collect(Collectors.toList());
    }

    @Override
    public List<ContactDTO> getAllContactsByLastName(String lastName) {
        List<Contact> contacts = repoContact.findAllByLastName(lastName);
        return contacts.stream().map(this::convertFromContactToContactDTO).collect(Collectors.toList());
    }

    @Override
    public ContactDTO removeContact(int id) {
        ContactDTO contactDTO = convertFromContactToContactDTO(repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND)));
        repoPhone.deleteAllByContactId(id);
        repoAddress.deleteAllByContactId(id);
        repoContact.deleteById(id);
        return contactDTO;
    }

//    public void removeAllAddressesByContactId(int id) {
//        repoAddress.deleteAllByContactId(id);
//    }

    @Override
    public void createPhone(PhoneNumberDTO phoneNumberDTO, int contactDTOId) {
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberDTO.getCode(),
                phoneNumberDTO.getNumber(),
                phoneNumberDTO.getType(),
                contactDTOId);
        repoPhone.save(phoneNumber);
    }

    @Override
    public PhoneNumberDTO editPhoneNumber(PhoneNumberDTO phoneNumberDTO, int id) {
        PhoneNumber phoneNumber = repoPhone.findById(id).orElseThrow(() -> new EntityNotFoundException(PHONE_NUMBER_NOT_FOUND));

        phoneNumber.setId(id);
        phoneNumber.setCode(phoneNumberDTO.getCode());
        phoneNumber.setNumber(phoneNumberDTO.getNumber());
        phoneNumber.setType(phoneNumberDTO.getType());

        return convertFromPhoneNumberToPhoneNumberDTO(repoPhone.save(phoneNumber));
    }

    @Override
    public PhoneNumberDTO removePhoneNumber(int contactDTOId, int id) {
        PhoneNumber phoneNumber = repoPhone.findById(id).orElseThrow(() -> new EntityNotFoundException(PHONE_NUMBER_NOT_FOUND));
        repoPhone.deleteByContactIdAndId(contactDTOId, id);
        return convertFromPhoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @Override
    public List<PhoneNumberDTO> getAllPhoneNumberByContactId(int id) {
        return repoPhone.findAllByContactId(id)
                .stream()
                .map(this::convertFromPhoneNumberToPhoneNumberDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PhoneNumberDTO convertFromPhoneNumberToPhoneNumberDTO(PhoneNumber phoneNumber) {
        return new PhoneNumberDTO(
                phoneNumber.getCode(),
                phoneNumber.getNumber(),
                phoneNumber.getType()
        );
    }


    @Override
    public AddressDTO convertFromAddressToAddressDTO(Address address) {
        return new AddressDTO(
                address.getCity(),
                address.getCountry(),
                address.getAddress(),
                address.getZip(),
                address.getType()
        );
    }


    @Override
    public ContactDTO convertFromContactToContactDTO(Contact contact) {
        return new ContactDTO(
                contact.getId(),
                contact.getName(),
                contact.getLastName(),
                contact.getDate(),
                getAllAddressesByContact(contact),
                getAllPhonesByContact(contact));
    }

    @Override
    public Contact convertFromContactDTOToContact(ContactDTO contactDTO) {
        return new Contact(contactDTO.getId(),
                contactDTO.getName(),
                contactDTO.getLastName(),
                contactDTO.getBirthday());

    }

    @Override
    public List<PhoneNumberDTO> getAllPhonesByContact(Contact contact) {
        int id = contact.getId();
        return repoPhone.findAllByContactId(id)
                .stream()
                .map(this::convertFromPhoneNumberToPhoneNumberDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAllAddressesByContact(Contact contact) {
        int id = contact.getId();
        return repoAddress.findAllByContactId(id)
                .stream()
                .map(this::convertFromAddressToAddressDTO)
                .collect(Collectors.toList());
    }

//    public List<PhoneNumberDTO> getAllPhonesByContactId(int id) {
//        List<PhoneNumber> phoneNumbers = repoPhone.findAllByContactId(id);
//        return phoneNumbers
//                .stream()
//                .map(this::convertFromPhoneNumberToPhoneNumberDTO)
//                .collect(Collectors.toList());
//    }
//
//    public List<AddressDTO> getAllAddressesByContactId(int id) {
//        List<Address> phoneNumbers = repoAddress.findAllByContactId(id);
//        return phoneNumbers
//                .stream()
//                .map(this::convertFromAddressToAddressDTO)
//                .collect(Collectors.toList());
//    }
}
