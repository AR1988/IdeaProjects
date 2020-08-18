package com.telran.telran.repo;

import com.telran.telran.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepo extends CrudRepository<Contact, Integer> {

    List<Contact> findAll();

    List<Contact> findAllByNameContainingIgnoreCase(String name);

    List<Contact> findAllByLastNameContainingIgnoreCase(String name);

    List<Contact> findAllByAge(int age);

    Contact findTopByOrderByIdDesc();
}
