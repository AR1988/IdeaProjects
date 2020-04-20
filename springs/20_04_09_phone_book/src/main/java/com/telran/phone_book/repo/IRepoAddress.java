package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IRepoAddress extends CrudRepository<Address, Integer> {

    List<Address> findAllByContactId(int contactId);

    void deleteAllByContactId(int id);

    Optional<Address> deleteById(int id);
}