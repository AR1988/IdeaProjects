package com.telran.phone_book.service;

import com.telran.phone_book.dto.PhoneNumberDTO;
import com.telran.phone_book.entity.PhoneNumber;
import com.telran.phone_book.repo.IRepoPhone;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PhoneService implements IPhoneService {
    private static final String PHONE_NUMBER_NOT_FOUND = "Phone Number Not found";

    private final IRepoPhone repoPhone;
    private final Utils utils;

    public PhoneService(IRepoPhone repoPhone, Utils utils) {
        this.repoPhone = repoPhone;
        this.utils = utils;
    }

    @Override
    public void createPhone(PhoneNumberDTO phoneNumberDTO, int contactDTOId) {
        repoPhone.save(new PhoneNumber(
                phoneNumberDTO.getCode(),
                phoneNumberDTO.getNumber(),
                phoneNumberDTO.getType(),
                contactDTOId));
    }

    @Override
    public PhoneNumberDTO editPhoneNumber(PhoneNumberDTO phoneNumberDTO, int id) {
        PhoneNumber phone = repoPhone.findById(id).orElseThrow(() -> new EntityNotFoundException(PHONE_NUMBER_NOT_FOUND));

        phone.setId(id);
        phone.setCode(phoneNumberDTO.getCode());
        phone.setNumber(phoneNumberDTO.getNumber());
        phone.setType(phoneNumberDTO.getType());
        repoPhone.save(phone);

        return convertToDto(phone);
    }

    @Override
    public PhoneNumberDTO removePhoneNumber(int id) {
        PhoneNumber phone = repoPhone.deleteById(id).orElseThrow(() -> new EntityNotFoundException(PHONE_NUMBER_NOT_FOUND));
        return convertToDto(phone);
    }

    //TODO contact not found
    @Override
    public void removeAllPhonesByContactId(int contactId) {
        repoPhone.deleteAllByContactId(contactId);
    }

    @Override
    public List<PhoneNumberDTO> getAllPhoneNumberByContactId(int id) {
        return repoPhone.findAllByContactId(id)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PhoneNumberDTO convertToDto(PhoneNumber phoneNumber) {
        return utils.convertFromPhoneNumberToPhoneNumberDTO(phoneNumber);
    }
}
