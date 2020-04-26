package com.telran.phone_book.service;

import com.telran.phone_book.dto.PhoneNumberDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IPhoneService {

    void createPhone(PhoneNumberDto phoneNumberDTO);

    PhoneNumberDto editPhoneNumber(PhoneNumberDto phoneNumberDTO);

    PhoneNumberDto removePhoneNumber(int id);

    void removeAllPhonesByContact(int id);

    List<PhoneNumberDto> getAllPhoneNumberByContact(int id);

    PhoneNumberDto getPhoneById(int id);
}