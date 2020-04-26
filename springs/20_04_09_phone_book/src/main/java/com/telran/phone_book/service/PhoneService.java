package com.telran.phone_book.service;

import com.telran.phone_book.dto.PhoneNumberDto;
import com.telran.phone_book.entity.Contact;
import com.telran.phone_book.entity.PhoneNumber;
import com.telran.phone_book.mapper.PhoneMapper;
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
public class PhoneService implements IPhoneService {

    static final String PHONE_NUMBER_NOT_FOUND = "Phone number not found";

    private final IRepoPhone repoPhone;
    private final PhoneMapper phoneMapper;
    private final IRepoContact repoContact;

    @Override
    public void createPhone(PhoneNumberDto phoneNumberDTO) {
        Contact contact = getContact(phoneNumberDTO.getPersonId());

        repoPhone.save(new PhoneNumber(
                phoneNumberDTO.getCode(),
                phoneNumberDTO.getNumber(),
                phoneNumberDTO.getType(),
                contact)
        );
    }

    @Override
    public PhoneNumberDto editPhoneNumber(PhoneNumberDto phoneNumberDTO) {
        PhoneNumber phone = getPhone(phoneNumberDTO.getPersonId());

        phone.setCode(phoneNumberDTO.getCode());
        phone.setNumber(phoneNumberDTO.getNumber());
        phone.setType(phoneNumberDTO.getType());
        repoPhone.save(phone);

        return convertToDto(phone);
    }

    @Override
    public PhoneNumberDto removePhoneNumber(int id) {
        PhoneNumber phone = getPhone(id);

        return convertToDto(phone);
    }

    @Override
    public void removeAllPhonesByContact(int id) {
        Contact contact = getContact(id);

        repoPhone.deleteAllByContact(contact);
    }

    @Override
    public List<PhoneNumberDto> getAllPhoneNumberByContact(int id) {
        Contact contact = getContact(id);

        return repoPhone.findAllByContact(contact)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhoneNumberDto getPhoneById(int id) {
        return convertToDto(getPhone(id));
    }

    private PhoneNumberDto convertToDto(PhoneNumber phoneNumber) {
        return phoneMapper.mapPhoneNumberToDto(phoneNumber);
    }

    private Contact getContact(int id) {
        return repoContact.findById(id).orElseThrow(() -> new EntityNotFoundException(ContactService.CONTACT_NOT_FOUND));
    }

    private PhoneNumber getPhone(int id) {
        return repoPhone.findById(id).orElseThrow(() -> new EntityNotFoundException(PHONE_NUMBER_NOT_FOUND));
    }
}
