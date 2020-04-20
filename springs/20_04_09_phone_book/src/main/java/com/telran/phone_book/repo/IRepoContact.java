package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepoContact extends CrudRepository<Contact, Integer> {


    List<Contact> findAll();

    List<Contact> findAllByName(String name);

    List<Contact> findAllByLastName(String lastName);

}
