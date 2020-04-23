package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Address;
import com.telran.phone_book.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IRepoAddress extends CrudRepository<Address, Integer> {

    List<Address> findAllByContact(Contact contact);

    void deleteAllByContact(Contact contact);

    Optional<Address> deleteById(int id);
}