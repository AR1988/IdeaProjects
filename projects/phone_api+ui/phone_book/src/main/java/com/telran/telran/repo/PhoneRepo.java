package com.telran.telran.repo;

import com.telran.telran.entity.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepo extends CrudRepository<Phone, Integer> {

    List<Phone> findAllByContactId(int contactId);

    void deleteAllByContactId(int id);
}
