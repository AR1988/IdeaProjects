package com.telran.phone_book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String name;

    @Setter
    private String lastName;

    @Setter
    private LocalDate birthday;

    @OneToMany(mappedBy = "contact" )
    private List<PhoneNumber> phones = new ArrayList<>();

    @OneToMany(mappedBy = "contact")
    private List<Address> addresses = new ArrayList<>();

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