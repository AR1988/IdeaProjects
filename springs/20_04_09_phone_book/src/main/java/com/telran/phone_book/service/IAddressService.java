package com.telran.phone_book.service;

import com.telran.phone_book.dto.AddressDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IAddressService {

    void createAddress(AddressDTO addressDTO, int contactDTOId);

    AddressDTO editAddress(AddressDTO addressDTO, int id);

    AddressDTO removeAddress(int contactDTOId, int id);

    List<AddressDTO> getAllAddressesByContactId(int id);
}

