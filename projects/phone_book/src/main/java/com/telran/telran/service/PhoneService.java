package com.telran.telran.service;

import com.telran.telran.dto.PhoneDto;
import com.telran.telran.entity.Phone;
import com.telran.telran.maping.PhoneMapping;
import com.telran.telran.repo.PhoneRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PhoneService {
    private final PhoneRepo repo;
    private final PhoneMapping mapping;
    private final String CONTACT_NOT_FOUND = "Contact not found";

    public void create(PhoneDto phoneDto) {
        repo.save(dtoToPhone(phoneDto));
    }


    @Transactional
    public void edit(PhoneDto phoneDto) {
        Phone phone = repo.findById(phoneDto.id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
        phone.setCode(phoneDto.code);
        phone.setNumber(phoneDto.number);
        phone.setType(phoneDto.getType());
    }

    public void remove(int id) {
        repo.deleteById(id);
    }

    public List<PhoneDto> getAll(int contactId) {
        return repo.findAllByContactId(contactId).stream()
                .map(this::phoneToDto)
                .collect(Collectors.toList());

    }

    public PhoneDto getById(int id) {
        Phone phone = repo.findById(id).orElseThrow(() -> new EntityNotFoundException(CONTACT_NOT_FOUND));
        return phoneToDto(phone);
    }

    private Phone dtoToPhone(PhoneDto phoneDto) {
        return mapping.phoneDtoToPhone(phoneDto);
    }

    private PhoneDto phoneToDto(Phone phone) {
        return mapping.phoneToPhoneDto(phone);
    }
}
