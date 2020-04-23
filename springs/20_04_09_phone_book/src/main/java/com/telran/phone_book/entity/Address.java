package com.telran.phone_book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private String city;

    @Setter
    @Getter
    private String country;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    private String zip;

    @Setter
    @Getter
    private String type;

    @Getter
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;


    public Address(String country, String city, String address, String zip, String type, Contact contact) {
        this.city = city;
        this.country = country;
        this.address = address;
        this.zip = zip;
        this.type = type;
        this.contact = contact;
    }
}