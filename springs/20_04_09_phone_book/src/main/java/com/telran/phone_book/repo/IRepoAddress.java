package com.telran.phone_book.repo;

import com.telran.phone_book.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepoAddress extends CrudRepository<Address, Integer> {

    List<Address> findAllByContactId(int contactId);

    void deleteAllByContactId(int id);

    void deleteByContactIdAndId(int contactId, int id);
}
