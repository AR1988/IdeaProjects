package com.telran.phone_book.repo;

import com.telran.phone_book.entity.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IRepoPhone extends CrudRepository<PhoneNumber, Integer> {

    List<PhoneNumber> findAllByContactId(int contactId);

    void deleteAllByContactId(int contactId);

    Optional<PhoneNumber> deleteById(int id);
}