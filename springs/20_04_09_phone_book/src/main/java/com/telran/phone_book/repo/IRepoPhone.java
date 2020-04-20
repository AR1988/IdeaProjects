package com.telran.phone_book.repo;

import com.telran.phone_book.entity.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepoPhone extends CrudRepository<PhoneNumber, Integer> {

    List<PhoneNumber> findAllByContactId(int contactId);

    void deleteAllByContactId(int contactId);

    PhoneNumber deleteById(int id);

    void deleteByContactIdAndId(int contactId, int id);
}
