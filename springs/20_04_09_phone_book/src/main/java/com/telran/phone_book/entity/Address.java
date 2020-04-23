package com.telran.phone_book.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String city;
    String country;
    String address;
    String zip;
    String type;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Contact contact;


    public Address(String country, String city, String address, String zip, String type) {
        this.city = city;
        this.country = country;
        this.address = address;
        this.zip = zip;
        this.type = type;
    }
}