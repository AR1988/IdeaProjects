package com.telran.phone_book.service;

import com.telran.phone_book.dto.PhoneNumberDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface IPhoneService {

    void createPhone(PhoneNumberDTO phoneNumberDTO, int contactDTOId);

    PhoneNumberDTO editPhoneNumber(PhoneNumberDTO phoneNumberDTO, int id);

    PhoneNumberDTO removePhoneNumber(int contactDTOId, int id);

    List<PhoneNumberDTO> getAllPhoneNumberByContactId(int id);
}
