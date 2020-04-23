package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDto;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.mapper.AddressMapper;
import com.telran.phone_book.repo.IRepoAddress;
import com.telran.phone_book.repo.IRepoContact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
public class AddressService implements IAddressService {

    public static final String ADDRESS_NOT_FOUND = "Address not found";

    private final IRepoAddress repoAddress;
    private final AddressMapper addressMapper;
    private final IRepoContact repoContact;

    @Override
    public void createAddress(AddressDto addressDTO) {
        Contact contact = getContact(addressDTO.getPersonId());

        repoAddress.save(new Address(addressDTO.getCountry(),
                addressDTO.getCity(),
                addressDTO.getAddress(),
                addressDTO.getZip(),
                addressDTO.getType(),
                contact)
        );
    }

    @Override
    public AddressDto editAddress(AddressDto addressDTO) {
        Address address = getAddress(addressDTO.personId);

        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setAddress(addressDTO.getAddress());
        address.setZip(addressDTO.getZip());
        address.setType(addressDTO.getType());

        repoAddress.save(address);

        return convertToDto(address);
    }

    @Override
    public AddressDto removeAddress(int addressId) {
        Address address = getAddress(addressId);

        return convertToDto(address);
    }

    @Override
    public void removeAllAddressesByContact(int id) {
        Contact contact = getContact(id);

        repoAddress.deleteAllByContact(contact);
    }

    @Override
    public List<AddressDto> getAllAddressesByContact(int id) {
        Contact contact = getContact(id);

        return repoAddress.findAllByContact(contact)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AddressDto convertToDto(Address address) {
        return addressMapper.mapAddressToDto(address);
    }

    private Contact getContact(int id) {
        return repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(ContactService.CONTACT_NOT_FOUND));
    }

    private Address getAddress(int id) {
        return repoAddress.findById(id).orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND));
    }
}