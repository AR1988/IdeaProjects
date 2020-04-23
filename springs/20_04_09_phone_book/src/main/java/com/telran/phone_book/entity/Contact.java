package com.telran.phone_book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Entity
@Setter
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    int id;
    @Getter
    String name;
    @Getter
    String lastName;
    @Getter
    LocalDate birthday;

    @OneToMany(mappedBy = "contact")
    List<PhoneNumber> phones;

    @OneToMany(mappedBy = "contact")
    List<Address> addresses;

    public Contact(int id, String name, String lastName, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public List<PhoneNumber> getPhones() {
        return Collections.unmodifiableList(phones);
    }

    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses);
    }
}