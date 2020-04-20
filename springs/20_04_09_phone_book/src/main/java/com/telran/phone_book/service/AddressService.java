package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDTO;
import com.telran.phone_book.entity.Address;
import com.telran.phone_book.repo.IRepoAddress;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class AddressService implements IAddressService {
    private static final String ADDRESS_NOT_FOUND = "Address not found";
    private final IRepoAddress repoAddress;
    private final Utils utils;

    public AddressService(IRepoAddress repoAddress, Utils utils) {
        this.repoAddress = repoAddress;
        this.utils = utils;
    }

    //TODO contact not found
    @Override
    public void createAddress(AddressDTO addressDTO, int contactDTOId) {
        repoAddress.save(new Address(addressDTO.getCity(),
                addressDTO.getCountry(),
                addressDTO.getAddress(),
                addressDTO.getZip(),
                addressDTO.getType(),
                contactDTOId));

    }

    @Override
    public AddressDTO editAddress(AddressDTO addressDTO, int addressId) {
        Address address = repoAddress.findById(addressId).orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND));

        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setAddress(addressDTO.getAddress());
        address.setZip(addressDTO.getZip());
        address.setType(addressDTO.getType());

        repoAddress.save(address);
        return convertToDto(address);
    }

    @Override
    public AddressDTO removeAddress(int addressId) {
        Address address = repoAddress.deleteById(addressId).orElseThrow(() -> new EntityNotFoundException(ADDRESS_NOT_FOUND));
        return convertToDto(address);
    }

    //TODO contact not found
    @Override
    public void removeAllAddressesByContactId(int contactId) {
        repoAddress.deleteAllByContactId(contactId);
    }

    //TODO contact not found
    @Override
    public List<AddressDTO> getAllAddressesByContactId(int contactId) {
        return repoAddress.findAllByContactId(contactId)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private AddressDTO convertToDto(Address address) {
        return utils.convertFromAddressToAddressDTO(address);
    }
}